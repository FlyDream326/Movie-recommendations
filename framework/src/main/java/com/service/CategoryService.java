package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.dto.AddCategoryDto;
import com.domain.vo.CategoryVo;
import com.domain.vo.PageVo;
import com.entity.Category;
import com.utils.ResponseResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2023-04-05 15:32:07
 */
public interface CategoryService extends IService<Category> {

    Long selectCategoryIdByName(String name);

    ResponseResult getCategoryList();

    List<CategoryVo> listAllCategory();

    void export(HttpServletResponse response);

    PageVo categoryList(Integer pageNum, Integer pageSize, String name, String status);

    void addCategory(AddCategoryDto dto);

    CategoryVo getCategoryById(Long id);

    void updateCategory(AddCategoryDto dto);
}

