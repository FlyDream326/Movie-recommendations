package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.category;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * (category)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:32:07
 */
@Service("typeService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, category> implements CategoryService {

}

