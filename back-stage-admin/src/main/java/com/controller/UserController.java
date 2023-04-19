package com.controller;

import com.domain.dto.AddUserDetailsDto;
import com.domain.dto.AddUserDto;
import com.domain.vo.PageVo;
import com.domain.vo.UserRoleDetailVo;
import com.service.UserService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author fly
 * @create 16:46
 */
@RestController
@RequestMapping("/system/user")
public class UserController{

    @Autowired
    private UserService userService;
    @GetMapping("list")
    public ResponseResult userList(@RequestParam
                                   Integer pageNum,
                                   Integer pageSize,
                                   String userName,
                                   String phonenumber,
                                   String status){
        PageVo pageVo=userService.userList(pageNum,pageSize,userName,phonenumber,status);
        return ResponseResult.okResult(pageVo);
    }
    @PostMapping
    public ResponseResult addUser(@RequestBody AddUserDto dto){
        userService.addUser(dto);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult deleteUserById(@PathVariable("id")Long id){
        userService.getBaseMapper().deleteById(id);
        return ResponseResult.okResult();
    }
    @GetMapping("/{id}")
    public ResponseResult getUserDetailsId(@PathVariable("id")Long id){
        UserRoleDetailVo userRoleDetailVo = userService.getUserDetailsId(id);
        return ResponseResult.okResult(userRoleDetailVo);
    }
    @PutMapping
    public ResponseResult updateUserDetails(@RequestBody AddUserDetailsDto dto){
        userService.updateUserDetails(dto);
        return ResponseResult.okResult();
    }
}
