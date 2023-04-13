package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Role;
import com.mapper.RoleMapper;
import com.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 15:41:48
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

