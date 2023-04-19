package com.controller;

import com.domain.vo.AdminUserInfoVo;
import com.entity.User;
import com.enums.AppHttpCodeEnum;
import com.exception.SystemException;
import com.service.LoginService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly
 * @create 11:18
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //用户名不能为空
          throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }
    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfoVo> getUserInfo(){
        return loginService.getInfo();
    }

    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
    @GetMapping("/getRouters")
    public ResponseResult getRouters(){
        return loginService.getRouters();
    }

}

