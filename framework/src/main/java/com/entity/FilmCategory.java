package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (FilmCategory)表实体类
 *
 * @author makejava
 * @since 2023-04-05 15:31:55
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("film_category")
public class FilmCategory {
    //电影id    
    @TableId
    private Long filmId;
    //类型id
    private Long categoryId;




}

