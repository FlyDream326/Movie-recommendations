package com.controller;

import com.domain.vo.FilmVo;
import com.domain.vo.PageVo;
import com.service.FilmService;
import com.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author fly
 * @create 16:22
 */
@RestController
@RequestMapping("/system")
public class FilmController {
    // TODO vue前台未完成
    @Resource
    private FilmService filmService;
    /**
     * 所有电影查询
     * filmName year 若有数值则进行模糊查询，空则进行分页查询，
     * pageNum、pageSize 分页查询（不能为空）
     *  isShow =  true 正在上映，false 即将上映, NULL 所有电影信息
     * @param filmName
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/film")
    public ResponseResult sysFilmList(@RequestParam(required = false) String filmName,
                                      @RequestParam(required = false) String year,
                                      @RequestParam("pageNum")Integer pageNum,
                                      @RequestParam("pageSize")Integer pageSize){
        //分页查询所有电影
        //filmName year 若有数值则进行模糊查询，空则进行分页查询，pageNum、pageSize 分页查询（不能为空）
        //isShow true 正在上映，false 即将上映 若值为NULL则不进行次条件查询
        //根据电影id 倒序
        PageVo vo = filmService.filmList(filmName,year,pageNum,pageSize,"NULL");
       return ResponseResult.okResult(vo);
    }
    /**
     * 即将上映电影查询
     * filmName year 若有数值则进行模糊查询，空则进行分页查询，
     * pageNum、pageSize 分页查询（不能为空）
     *  isShow =  true 正在上映，false 即将上映
     * @param filmName
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/unShowingList")
    public ResponseResult unShowingList(@RequestParam(required = false) String filmName,
                                        @RequestParam(required = false) String year,
                                        @RequestParam("pageNum")Integer pageNum,
                                        @RequestParam("pageSize")Integer pageSize){
        //filmName year 若有数值则进行模糊查询，空则进行分页查询，pageNum、pageSize 分页查询（不能为空）
        //        true 正在上映，false 即将上映
        PageVo pageVo = filmService.filmList(filmName,year,pageNum,pageSize, "false");
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 正在上映电影查询
     * filmName year 若有数值则进行模糊查询，空则进行分页查询，
     * pageNum、pageSize 分页查询（不能为空）
     *  isShow =  true 正在上映，false 即将上映
     * @param filmName
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/showingList")
    public ResponseResult showingList(@RequestParam(required = false) String filmName,
                                      @RequestParam(required = false) String year,
                                      @RequestParam("pageNum")Integer pageNum,
                                      @RequestParam("pageSize")Integer pageSize){

        //
        PageVo pageVo = filmService.filmList(filmName,year,pageNum,pageSize, "true");
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 根据id 逻辑删除电影信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteFilmById(@PathVariable("id") Long id){
        filmService.deleteFilmById(id);
        return ResponseResult.okResult();
    }
    /**
     * 更新电影信息
     * @param dto
     * @return
     */
    @PutMapping("/up")
    public ResponseResult upDataInfo(@RequestBody FilmVo dto){
       return filmService.upDataInfo(dto);
    }

    /**
     * 添加电影信息
     * @param dto
     * @return
     */
    @PostMapping("/ad")
    public ResponseResult addFilmInfo(@RequestBody FilmVo dto){
        return filmService.addFilmInfo(dto);
    }

}
