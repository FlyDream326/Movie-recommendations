package com.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FilmVo {
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
    //是否上映(0真,1假)
    private String isShow;

    private List<ActorVo> actors;
    private List<String> types;

}
