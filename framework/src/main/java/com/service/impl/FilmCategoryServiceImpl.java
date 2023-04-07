package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.FilmCategory;
import com.mapper.FilmCategoryMapper;
import com.service.FilmCategoryService;
import org.springframework.stereotype.Service;

/**
 * (FilmCategory)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:31:55
 */
@Service("filmTypeService")
public class FilmCategoryServiceImpl extends ServiceImpl<FilmCategoryMapper, FilmCategory> implements FilmCategoryService {

}

