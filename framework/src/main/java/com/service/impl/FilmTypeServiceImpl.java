package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.FilmType;
import com.mapper.FilmTypeMapper;
import com.service.FilmTypeService;
import org.springframework.stereotype.Service;

/**
 * (FilmType)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:31:55
 */
@Service("filmTypeService")
public class FilmTypeServiceImpl extends ServiceImpl<FilmTypeMapper, FilmType> implements FilmTypeService {

}

