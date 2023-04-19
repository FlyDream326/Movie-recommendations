package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (City)表实体类
 *
 * @author makejava
 * @since 2023-04-16 15:51:04
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("city")
public class City  {
    //城市id    
    @TableId
    private Long cityId;

    //城市名字
    private String name;
    //城市拼音
    private String pinyin;
    //是否Hot(1是, 0 否)
    private String ishot;



}

