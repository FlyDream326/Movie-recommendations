package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.RoleMenu;
import com.mapper.RoleMenuMapper;
import com.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色和菜单关联表(RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 15:39:02
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}

