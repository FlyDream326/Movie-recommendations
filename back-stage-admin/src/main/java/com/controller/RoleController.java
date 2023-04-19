package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.constants.SystemConstants;
import com.domain.dto.RoleDto;
import com.domain.dto.RoleUpDataDto;
import com.domain.vo.PageVo;
import com.domain.vo.RoleVo;
import com.entity.Role;
import com.service.RoleService;
import com.utils.BeanCopyUtils;
import com.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Resource
    private RoleService roleService;
    @GetMapping("/list")
    public ResponseResult roleList(Integer pageNum, Integer pageSize, String roleName, String status){
      PageVo pageVo = roleService.roleList(pageNum,pageSize,roleName,status);
        return ResponseResult.okResult(pageVo);
    }
    @PutMapping("/changeStatus")
    public ResponseResult roleStatus(@RequestBody RoleVo roleVo){
        //改变角色状态
        roleService.getBaseMapper().updateById(new Role(roleVo.getId(),roleVo.getStatus()));
        return ResponseResult.okResult();
    }
    @GetMapping("/listAllRole")
    public ResponseResult listAllRole(){
        LambdaQueryWrapper<Role> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getStatus, SystemConstants.STATUS_NORMAL);
        return ResponseResult.okResult(roleService.list(queryWrapper));
    }
    @PostMapping
    public ResponseResult addRole(@RequestBody RoleDto dto){
        roleService.addRole(dto);
    return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult deleteRole(@PathVariable("id")Long id){
        //逻辑删除角色
        roleService.getBaseMapper().deleteById(id);
    return ResponseResult.okResult();
    }

    /**
     * 根据id 查询Role表 返回角色信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult showRoleInfo(@PathVariable("id")Long id){
        Role role = roleService.getById(id);
        RoleVo roleVo = BeanCopyUtils.copyBean(role, RoleVo.class);
        return ResponseResult.okResult(roleVo);
    }

    /**
     * 根据 RoleUpDataDto 更新 role表和role&menu关联表
     * @param dto
     * @return
     */
    @PutMapping
    public ResponseResult upDataRoleInfo(@RequestBody RoleUpDataDto dto){
      return   roleService.upDataRoleInfo(dto);

    }
}
