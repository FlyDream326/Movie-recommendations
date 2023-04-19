package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.City;
import com.mapper.CityMapper;
import com.service.CityService;
import org.springframework.stereotype.Service;

/**
 * (City)表服务实现类
 *
 * @author makejava
 * @since 2023-04-16 15:51:05
 */
@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

}

