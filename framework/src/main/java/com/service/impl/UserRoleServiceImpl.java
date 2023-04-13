package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.UserRole;
import com.mapper.UserRoleMapper;
import com.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户和角色关联表(UserRole)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 15:38:41
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}

