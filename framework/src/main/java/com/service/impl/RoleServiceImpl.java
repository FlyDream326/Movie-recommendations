package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constants.SystemConstants;
import com.domain.dto.RoleDto;
import com.domain.dto.RoleUpDataDto;
import com.domain.vo.PageVo;
import com.domain.vo.RoleVo;
import com.entity.Role;
import com.entity.RoleMenu;
import com.mapper.RoleMapper;
import com.service.RoleMenuService;
import com.service.RoleService;
import com.utils.BeanCopyUtils;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 15:41:48
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员 如果是返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }
        //否则查询用户所具有的角色信息
        return getBaseMapper().selectRoleKeyByUserId(id);
    }

    @Override
    public PageVo roleList(Integer pageNum, Integer pageSize, String roleName, String status) {
        LambdaQueryWrapper<Role> queryWrapper =
                new LambdaQueryWrapper<>();
        //需要有角色列表分页查询的功能
        //要求能够针对角色名称进行模糊查询
        queryWrapper.like(StringUtils.hasText(roleName),Role::getRoleName,roleName)
                .eq(StringUtils.hasText(status),Role::getStatus,status)
                .eq(!StringUtils.hasText(status),Role::getStatus, SystemConstants.STATUS_NORMAL);
        //要求按照role_sort进行升序排列
        queryWrapper.orderByAsc(Role::getRoleSort);
        //需要有角色列表分页查询的功能
        Page<Role> page = new Page<>(pageNum,pageSize);

        page(page,queryWrapper);
        List<RoleVo> roleVos = BeanCopyUtils.copyBeanList(page.getRecords(), RoleVo.class);
        return new PageVo(roleVos,page.getTotal());
    }

    @Override
    public void addRole(RoleDto dto) {
        Role role = BeanCopyUtils.copyBean(dto, Role.class);
        save(role);
        List<RoleMenu> roleMenus = dto.getMenuIds().stream()
                .map(ids -> new RoleMenu(role.getId(), Long.valueOf(ids)))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenus);
    }
    //根据 RoleUpDataDto 更新 role表和role&menu关联表
    @Override
    public ResponseResult upDataRoleInfo(RoleUpDataDto dto) {
        //  获取菜单id的list
        List<Long> menuIds = dto.getMenuIds();
        Role role = BeanCopyUtils.copyBean(dto, Role.class);
        LambdaQueryWrapper<Role> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getId,role.getId());
        update(role,queryWrapper);
        List<RoleMenu> roleMenus = menuIds.stream()
                .map(mid -> new RoleMenu(role.getId(), mid))
                .collect(Collectors.toList());
        roleMenuService.saveOrUpdateBatch(roleMenus);
        return ResponseResult.okResult();
    }
}

