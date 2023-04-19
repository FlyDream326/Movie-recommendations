package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.vo.FilmVo;
import com.domain.vo.PageVo;
import com.entity.Film;
import com.utils.ResponseResult;


/**
 * (Film)表服务接口
 *
 * @author makejava
 * @since 2023-04-05 15:27:13
 */
public interface FilmService extends IService<Film> {

    PageVo filmList(String filmName, String year, Integer pageNum, Integer pageSize, String isShow);

    FilmVo getFilmById(Long id);

    PageVo getFilmByCategoryId(Long cid, Integer pageNum, Integer pageSize);

    PageVo sysFilmList(Integer pageNum, Integer pageSize);

    void deleteFilmById(Long id);

    ResponseResult upDataInfo(FilmVo dto);

    ResponseResult addFilmInfo(FilmVo dto);
}

