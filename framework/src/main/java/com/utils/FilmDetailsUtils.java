package com.utils;

import com.alibaba.fastjson.JSON;

public class FilmDetailsUtils {
    public static void main(String[] args) {
        String str = new String("片名：宇宙探索编辑部（2021）8.4分\n" +
                "别名：宇宙编辑部的故事 Journey to the West \n" +
                "上映：2023-04-01(中国大陆) \n" +
                "时长：118分钟 \n" +
                "类别：喜剧 科幻 \n" +
                "地区：中国大陆 \n" +
                "语言：汉语普通话 \n" +
                "导演：孔大山 \n" +
                "演员：杨皓宇 艾丽娅 王一通 蒋奇明 盛晨晨 郭帆 龚格尔 洛翼云 \n" +
                "简介：脑洞大开高分奇片，地球人外星人千里奔现！\n" +
                "唐志军（杨皓宇 饰）是一家诞生于上世纪八十年代的科幻杂志——《宇宙探索》编辑部的主编。现如今的杂志社日渐式微，唐志军也终成落魄潦倒，鳏寡孤独之人。但他却依然几十年如一日的痴迷于寻找地外文明。终于有一天，他接收到了一个疑似来自宇宙深处的异常信号，于是他召集同是天涯沦落人的伙伴们，带着那一个困惑他终生的问题，再一次踏上寻找外星人的旅途。");
        FilmAddUtils filmAddUtils = new FilmAddUtils().strToFilms(str);
        System.out.println(JSON.toJSON(filmAddUtils));


    }


}
