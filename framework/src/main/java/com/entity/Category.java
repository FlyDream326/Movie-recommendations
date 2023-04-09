package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Category)表实体类
 *
 * @author makejava
 * @since 2023-04-05 15:32:07
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Category")
public class Category {
    //类型id    
    @TableId
    private Long id;

    //类型name
    private String name;



}

