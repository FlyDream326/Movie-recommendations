package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.vo.CinemasVo;
import com.entity.Cinemas;
import com.entity.District;
import com.mapper.CinemasMapper;
import com.mapper.DistrictMapper;
import com.service.CinemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cinemas)表服务实现类
 *
 * @author makejava
 * @since 2023-04-15 10:33:49
 */
@Service("cinemasService")
public class CinemasServiceImpl extends ServiceImpl<CinemasMapper, Cinemas> implements CinemasService {




    @Resource
    private DistrictMapper districtMapper;
    @Override
    public CinemasVo cinemaList() {
        //获取所有影院信息
        // 1 查询影院信息
        List<Cinemas> list = list();
        // 2 查询District信息
        LambdaQueryWrapper<District> queryWrapper =
                new LambdaQueryWrapper<>();

        // 3 封装Vo,返回
        return null;
    }
}

