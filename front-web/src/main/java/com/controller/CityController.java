package com.controller;

import com.domain.vo.PageVo;
import com.entity.City;
import com.service.CityService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author fly
 * @create 15:53
 */
@RestController
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/getCities")
    public ResponseResult cityList(){
        // 获取城市列表
        List<City> list = cityService.list();
        return  ResponseResult.okResult(new PageVo(list,new Long(list.size())));
    }
}
