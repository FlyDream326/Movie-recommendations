package com.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    //状态0:正常,1禁用
    private String status;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;



}

