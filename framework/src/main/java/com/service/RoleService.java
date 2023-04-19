package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.dto.RoleDto;
import com.domain.dto.RoleUpDataDto;
import com.domain.vo.PageVo;
import com.entity.Role;
import com.utils.ResponseResult;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-04-12 15:41:48
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long id);

    PageVo roleList(Integer pageNum, Integer pageSize, String roleName, String status);

    void addRole(RoleDto dto);

    ResponseResult upDataRoleInfo(RoleUpDataDto dto);
}

