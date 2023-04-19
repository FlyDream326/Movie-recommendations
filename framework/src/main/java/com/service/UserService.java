package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.dto.AddUserDetailsDto;
import com.domain.dto.AddUserDto;
import com.domain.vo.PageVo;
import com.domain.vo.UserRoleDetailVo;
import com.entity.User;
import com.utils.ResponseResult;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-04-12 14:44:24
 */
public interface UserService extends IService<User> {
    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);


    PageVo userList(Integer pageNum, Integer pageSize, String userName, String phonenumber, String status);

    void addUser(AddUserDto dto);

    UserRoleDetailVo getUserDetailsId(Long id);

    void updateUserDetails(AddUserDetailsDto dto);

}

