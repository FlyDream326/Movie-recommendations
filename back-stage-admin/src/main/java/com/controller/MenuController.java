package com.controller;

import com.domain.vo.MenuVoSimple;
import com.entity.Menu;
import com.service.MenuService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 需要展示菜单列表，不需要分页。
     * 可以针对菜单名进行模糊查询
     * 也可以针对菜单的状态进行查询。
     * 菜单要按照父菜单id和orderNum进行排序
     * @param status
     * @param menuName
     * @return
     */
    @GetMapping("/list")
    public ResponseResult menuList(String status, String menuName){
      List<Menu> menuList = menuService.menuList(status,menuName);
        return ResponseResult.okResult(menuList);
    }
    @PostMapping
    public ResponseResult addMenu(@RequestBody Menu  menu){
        return menuService.addMenu(menu);
    }
    @GetMapping("/{id}")
    public ResponseResult getMenuById(@PathVariable("id")Long id){
       return ResponseResult.okResult(menuService.getById(id));
    }
    @PutMapping
    //@SystemLog(businessName = "更新菜单")
    public ResponseResult updateMenu(@RequestBody Menu menu){
        if (menu.getId().equals(menu.getParentId())){
            return ResponseResult.errorResult(500,"修改菜单'写博文'失败，上级菜单不能选择自己");
        }
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{menuId}")
    public ResponseResult deleteMenu(@PathVariable("menuId")Long id){
        return menuService.deleteMenu(id);
    }

    @GetMapping("/treeselect")
    public  ResponseResult menuTreeSelect(){
        //获取角色权限树
      List<MenuVoSimple> menuTreeSelect = menuService.menuTreeSelect();
        return ResponseResult.okResult(menuTreeSelect);
    }
    @GetMapping("/roleMenuTreeselect/{id}")
    public  ResponseResult menuRoleTree(@PathVariable("id")Long id){
        //获取角色权限树
        return  menuService.menuRoleTreeSelect(id);

    }

}
