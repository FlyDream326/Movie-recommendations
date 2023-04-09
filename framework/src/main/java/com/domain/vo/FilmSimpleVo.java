package com.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FilmSimpleVo {
    //电影id
    private Long id;

    //开拍年份
    private String year;
    //电影名称
    private String filmName;
    //电影海报
    private String poster;
}
