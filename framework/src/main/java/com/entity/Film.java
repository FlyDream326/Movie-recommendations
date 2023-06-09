package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Film)表实体类
 *
 * @author makejava
 * @since 2023-04-05 15:27:13
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("film")
public class Film  {
    //电影id
    @TableId
    private Long id;

    //开拍年份
    private String year;
    //电影名称
    private String filmName;
    //电影海报
    private String poster;
    //导演
    private String director;
    //电影简介
    private String synopsis;
    //电影出版国家
    private String nation;
    //电影时长
    private String filmShowtime;
    //语言
    private String language;
    //上映时间
    private String runtime;
    //评分
    private String grades;
    //是否上映(true真,false假)
    private String isShow;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;



}

