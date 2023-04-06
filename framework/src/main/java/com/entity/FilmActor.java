package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (FilmActor)表实体类
 *
 * @author makejava
 * @since 2023-04-05 15:31:41
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("film_actor")
public class FilmActor  {
    //电影id    
    @TableId
    private Long filmId;
    //演员id
    private Long actorId;




}

