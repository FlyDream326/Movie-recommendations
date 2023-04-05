package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Type;
import com.mapper.TypeMapper;
import com.service.TypeService;
import org.springframework.stereotype.Service;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:32:07
 */
@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}

