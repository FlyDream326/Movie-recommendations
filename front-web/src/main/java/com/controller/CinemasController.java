package com.controller;

import com.domain.vo.PageVo;
import com.entity.Cinemas;
import com.service.CinemasService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author fly
 * @create 10:36
 */
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    @Autowired
    public CinemasService cinemasService;

    @GetMapping("/list")
    public ResponseResult cinemaList(){
        //获取所有影院信息
       //CinemasVo vo =  cinemasService.cinemaList();
        List<Cinemas> list =  cinemasService.list();
       return ResponseResult.okResult(new PageVo(new Long(list.size()),list));
    }

}

