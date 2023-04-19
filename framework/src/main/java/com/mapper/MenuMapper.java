package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.dto.MenuDto;
import com.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-12 15:43:06
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long id);

    List<Menu> selectAllRouterMenu();

    List<Menu> selectRouterMenuByUserId(Long userId);

    List<String> selectPermsByUserKey(Long userId);

    List<MenuDto> menuRoleTreeSelect(Long id);

    List<MenuDto> allMenuRoleTreeSelect();
}

