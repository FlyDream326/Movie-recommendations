package com.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constants.SystemConstants;
import com.domain.dto.AddCategoryDto;
import com.domain.vo.CategoryVo;
import com.domain.vo.ExcelCategoryVo;
import com.domain.vo.PageVo;
import com.entity.Category;
import com.enums.AppHttpCodeEnum;
import com.exception.SystemException;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
import com.utils.BeanCopyUtils;
import com.utils.ResponseResult;
import com.utils.WebUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:32:07
 */
@Service("typeService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Long selectCategoryIdByName(String name) {
        return categoryMapper.selectCategoryIdByName(name);
    }

    @Override
    public ResponseResult getCategoryList() {

        //查询分类表
        List<Category> categories = list();

        categories = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装 vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }

    @Override
    public List<CategoryVo> listAllCategory() {
        LambdaQueryWrapper<Category> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getStatus,SystemConstants.STATUS_NORMAL);
        List<Category> categoryList = list(queryWrapper);
        List<CategoryVo> categoryVoList = BeanCopyUtils.copyBeanList(categoryList, CategoryVo.class);
        return categoryVoList;
    }

    @Override
    public void export(HttpServletResponse response) {
        //设置下载文件的请求头

        try {
            WebUtils.setDownLoadHeader("分类.xlsx",response);
            //获取需要导出的数据
            List<Category> categoryList = list();
            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(categoryList, ExcelCategoryVo.class);
            //把数据写入Excel中
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class).autoCloseStream(Boolean.FALSE).sheet("分类导出")
                    .doWrite(excelCategoryVos);

        } catch (Exception e) {
            //异常： 响应异常JSON
            //throw new SystemException(e);
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            WebUtils.renderString(response, JSON.toJSONString(result));
        }



    }

    @Override
    public PageVo categoryList(Integer pageNum, Integer pageSize, String name, String status) {
//        需要分页查询分类列表。
//	能根据分类名称进行模糊查询。
//	能根据状态进行查询。
        LambdaQueryWrapper<Category> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(name),Category::getName,name)
                .eq(StringUtils.hasText(status),Category::getStatus,status);
        Page<Category> categoryPage = new Page<>(pageNum,pageSize);
        page(categoryPage,queryWrapper);
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categoryPage.getRecords(), CategoryVo.class);
        return new PageVo(categoryVos,categoryPage.getTotal());
    }

    @Override
    public void addCategory(AddCategoryDto dto) {
        if(isCategoryExist(dto.getName())){
            throw  new SystemException(AppHttpCodeEnum.CATEGORY_EXIST);
        }
        Category category = BeanCopyUtils.copyBean(dto, Category.class);
        //解决前端 delFlag = null
        category.setDelFlag(0);
        save(category);

    }

    @Override
    public CategoryVo getCategoryById(Long id) {
        LambdaQueryWrapper<Category> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getId,id)
                .eq(Category::getStatus, SystemConstants.STATUS_NORMAL);
        Category category = getOne(queryWrapper);
        CategoryVo categoryVo = BeanCopyUtils.copyBean(category, CategoryVo.class);
        return categoryVo;
    }

    @Override
    public void updateCategory(AddCategoryDto dto) {
        Category category = BeanCopyUtils.copyBean(dto, Category.class);
        saveOrUpdate(category);
    }

    private boolean isCategoryExist(String name) {
        LambdaQueryWrapper<Category> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getName,name);
        return count(queryWrapper)>0;
    }

}

