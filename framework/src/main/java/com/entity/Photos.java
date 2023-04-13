package com.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (Photos)表实体类
 *
 * @author makejava
 * @since 2023-04-12 15:40:29
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("photos")
public class Photos  {

    @TableId
    private Long id;

    private Long filmid;
    
    private String urladdress;



}

