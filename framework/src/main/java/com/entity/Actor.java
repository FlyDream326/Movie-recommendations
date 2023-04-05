package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Actor)表实体类
 *
 * @author makejava
 * @since 2023-04-05 15:29:24
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("actor")
public class Actor  {
    //演员id    
    @TableId
    private Long id;

    //演员名字
    private String name;
    //扮演的角色
    private String role;
    //演员照片URL
    private String avataraddress;



}

