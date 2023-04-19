package com.service;


import com.domain.vo.AdminUserInfoVo;
import com.entity.User;
import com.utils.ResponseResult;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();

    ResponseResult<AdminUserInfoVo> getInfo();

    ResponseResult getRouters();
}
