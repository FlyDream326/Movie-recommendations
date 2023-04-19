package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constants.SystemConstants;
import com.domain.vo.ActorVo;
import com.domain.vo.FilmSimpleVo;
import com.domain.vo.FilmVo;
import com.domain.vo.PageVo;
import com.entity.Actor;
import com.entity.Film;
import com.entity.FilmActor;
import com.entity.FilmCategory;
import com.enums.AppHttpCodeEnum;
import com.mapper.FilmMapper;
import com.service.*;
import com.utils.BeanCopyUtils;
import com.utils.MybatisUtils;
import com.utils.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Film)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:27:14
 */
@Service("filmService")
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements FilmService {
    @Resource
    private FilmActorService filmActorService;
    @Resource
    private FilmCategoryService filmCategoryService;
    @Resource
    private ActorService actorService;
    @Resource
    private CategoryService categoryService;

    @Override
    public PageVo filmList(String filmName, String year, Integer pageNum, Integer pageSize, String isShow) {
        LambdaQueryWrapper<Film> queryWrapper =
                new LambdaQueryWrapper<>();
        //filmName year 若有数值则进行模糊查询，空则进行分页查询，pageNum、pageSize 分页查询（不能为空）
        //isShow true 正在上映，false 即将上映 若值为NULL则不进行次条件查询
        //根据电影id 倒序
        queryWrapper.like(StringUtils.hasText(filmName),Film::getFilmName,filmName)
                .like(StringUtils.hasText(year),Film::getYear,year)
                .eq(!isShow.equals("NULL"),Film::getIsShow,isShow)
                .orderByDesc(Film::getId);
        Page<Film> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);
        //存放 电影演员List、电影类型List
        List<FilmVo> filmVos = BeanCopyUtils.copyBeanList(page.getRecords(), FilmVo.class);
        List<FilmVo> collect = filmVos.stream()
                .map(filmVo -> filmVo.setActors(getActors(filmVo.getId())))
                .map(filmVo -> filmVo.setCategories(getCategory(filmVo.getId())))
                .collect(Collectors.toList());
        return new PageVo(collect,page.getTotal());
    }


    public FilmVo getFilmById(Long id) {
        Film film = getById(id);
        FilmVo filmVo = BeanCopyUtils.copyBean(film, FilmVo.class);
        filmVo.setCategories(getCategory(id));
        filmVo.setActors(getActors(id));
        return filmVo;
    }

    @Override
    public PageVo getFilmByCategoryId(Long cid, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<FilmCategory> wrap = new LambdaQueryWrapper<>();
        wrap.eq(FilmCategory::getCategoryId, cid);
        List<FilmCategory> list = filmCategoryService.list(wrap);
        List<Long> collect = list.stream()
                .map(FilmCategory::getFilmId)
                .collect(Collectors.toList());
        List<Film> films = listByIds(collect);
        //手动分页
        List<Film> films1 = null;
        try {
            films1 = MybatisUtils.subList(films, pageNum, pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<FilmSimpleVo> vos = BeanCopyUtils.copyBeanList(films1, FilmSimpleVo.class);
        return new PageVo(vos,new Long(vos.size()));
    }

    /**
     * 暂时未被使用
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageVo sysFilmList(Integer pageNum, Integer pageSize) {
        //查询所有未被删除的电影信息
        LambdaQueryWrapper<Film> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Film::getDelFlag, SystemConstants.STATUS_NORMAL);
        Page<Film> filmPage = new Page<>(pageNum,pageSize);
        page(filmPage,queryWrapper);
        // 增添演员表和标签 返回FilmVo
        List<FilmVo> filmVos = BeanCopyUtils.copyBeanList(filmPage.getRecords(), FilmVo.class);
        List<FilmVo> vos = filmVos.stream()
                .map(filmVo -> filmVo.setCategories(getCategory(filmVo.getId())))
                .map(filmVo -> filmVo.setActors(getActors(filmVo.getId())))
                .collect(Collectors.toList());
        return new PageVo(vos,filmPage.getTotal());
    }

    /**
     * 根据id 逻辑删除电影信息
     * @param id
     */
    @Override
    public void deleteFilmById(Long id) {
        this.getBaseMapper().deleteById(id);
    }

    /**
     * 更新电影信息
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult upDataInfo(FilmVo dto) {
        Film film = BeanCopyUtils.copyBean(dto, Film.class);
        if(StringUtils.hasText(film.getId().toString())){
            LambdaQueryWrapper<Film> queryWrapper =
                    new LambdaQueryWrapper<>();
            queryWrapper.eq(Film::getId,film.getId());
            //更新 演员&电影表,分类&电影表
            update(film,queryWrapper);
            upDataActorCategory(dto.getId(),
                    dto.getActors(),
                    dto.getCategories());
            return ResponseResult.okResult();
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.ID_NOT_NULL);
        }

    }
    /**
     * 添加电影信息
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult addFilmInfo(FilmVo dto) {
        Film film = BeanCopyUtils.copyBean(dto, Film.class);
        LambdaQueryWrapper<Film> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Film::getFilmName,film.getFilmName());
        // 电影信息已存在,返回 (514,"电影信息已存在")
        // 否则 保存电影信息
        if(count(queryWrapper)>0){
            return ResponseResult.errorResult(AppHttpCodeEnum.FILM_INFO_EXIST);
        }else {
            save(film);
            //更新 演员&电影表,分类&电影表
            upDataActorCategory(film.getId(),
                    dto.getActors(),
                    dto.getCategories());
            return ResponseResult.okResult();
        }


    }


    private List<ActorVo> getActors(Long id) {
        //通过film_id 获取演员表
        LambdaQueryWrapper<FilmActor> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(FilmActor::getFilmId,id);
        List<FilmActor> filmActors = filmActorService.list(queryWrapper);
        List<Actor> actors = filmActors.stream()
                .map(f -> actorService.getById(f.getActorId()))
                .collect(Collectors.toList());
        List<ActorVo> actorVos = BeanCopyUtils.copyBeanList(actors, ActorVo.class);
        return actorVos;
    }
    private List<String> getCategory(Long id) {
        //通过film_id 获取类型表
        LambdaQueryWrapper<FilmCategory> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(FilmCategory::getFilmId,id);
        List<FilmCategory> filmCategories = filmCategoryService.list(queryWrapper);
        List<String> typesVo = filmCategories.stream()
                .map(f -> categoryService.getById(f.getCategoryId()))
                .map(type -> type.getName())
                .collect(Collectors.toList());
        return typesVo;
    }

    /**
     * 更新 电影&演员表,电影&分类表 方法
     * @param id
     * @param actors
     * @param categories
     */
    private void upDataActorCategory(Long id, List<ActorVo> actors, List<String> categories) {
       // 根据电影id,演员id 生成 FilmActor 列表
        List<FilmActor> filmActors = actors.stream()
                .map(fa -> new FilmActor(id, fa.getId()))
                .collect(Collectors.toList());
        filmActorService.saveOrUpdateBatch(filmActors,filmActors.size());
        // 跟分类名称查询id 列表
        List<Long> idCollect = categories.stream()
                .map(name -> categoryService.selectCategoryIdByName(name))
                .collect(Collectors.toList());
        // 根据电影id,分类id 生成 FilmCategory 列表
        List<FilmCategory> filmCategories = idCollect.stream()
                .map(cid -> new FilmCategory(id, cid))
                .collect(Collectors.toList());
        // 更新或新增 filmActors,filmCategories
            filmActorService.saveOrUpdateBatch(filmActors,filmActors.size());
            filmCategoryService.saveOrUpdateBatch(filmCategories,filmCategories.size());

    }
}

