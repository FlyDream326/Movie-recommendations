package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (District)表实体类
 *
 * @author makejava
 * @since 2023-04-15 10:34:20
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("district")
public class District  {
        
    @TableId
    private Long districtid;

    
    private String name;



}

