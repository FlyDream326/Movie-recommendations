package com.service.impl;


import com.domain.vo.AdminUserInfoVo;
import com.domain.vo.MenuVo;
import com.domain.vo.RoutersVo;
import com.domain.vo.UserInfoVo;
import com.entity.LoginUser;
import com.entity.User;
import com.enums.AppHttpCodeEnum;
import com.service.LoginService;
import com.service.MenuService;
import com.service.RoleService;
import com.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = manager.authenticate(authenticationToken);
        //判断认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或者密码错误");
        }
        //获取userId 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        //如果获取不到
        if(Objects.isNull(loginUser)){
            //提示重新登录
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);

        }
        String id = loginUser.getUser().getId().toString();
        String token = JwtUtil.createJWT(id);
        //把用户信息存入redis
        redisCache.setCacheObject("back:"+id,loginUser);
        System.out.println("信息存入Redis,id = "+id);
        //把user转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);

        //把token和userinfo封装 返回
        //BlogUserLoginVo Vo = new BlogUserLoginVo(token,userInfoVo);
        //SecurityContextHolder.getContext().setAuthentication();
        Map<String,String> map =new HashMap<>();
        map.put("token",token);
        return ResponseResult.okResult(map);
    }


    public ResponseResult logout() {
        //获取userId
        String id = SecurityUtils.getUserId().toString();
        //删除redis中的用户信息
        redisCache.deleteObject("back:"+id);

        return ResponseResult.okResult(200,"退出成功！");
    }



    public ResponseResult<AdminUserInfoVo> getInfo() {
        //获取当前登录的用id
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询权限信息
        List<String> permsList = menuService.selectPermsByUserKey(userId);
        //根据用户id查询角色信息
        List<String>  roleKeyList = roleService.selectRoleKeyByUserId(userId);
        //获取用户信息User
        User user = SecurityUtils.getLoginUser().getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        //封装数据返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(permsList,roleKeyList,userInfoVo);

        return ResponseResult.okResult(adminUserInfoVo);
    }


    public ResponseResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        //查询menu 结果是tree的形式
         List<MenuVo> menuVos = menuService.selectRouterMenuTreeByUserId(userId);

        //封装数据返回
        return ResponseResult.okResult(new RoutersVo(menuVos));
    }

}
