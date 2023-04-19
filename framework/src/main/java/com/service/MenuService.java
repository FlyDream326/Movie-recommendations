package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.vo.MenuVo;
import com.domain.vo.MenuVoSimple;
import com.entity.Menu;
import com.utils.ResponseResult;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-04-12 15:43:06
 */
public interface MenuService extends IService<Menu> {


    List<String> selectPermsByUserKey(Long userId);

    List<MenuVo> selectRouterMenuTreeByUserId(Long userId);

    List<Menu> menuList(String status, String menuName);

    ResponseResult addMenu(Menu menu);

    ResponseResult deleteMenu(Long id);

    List<MenuVoSimple> menuTreeSelect();

    ResponseResult menuRoleTreeSelect(Long id);
}

