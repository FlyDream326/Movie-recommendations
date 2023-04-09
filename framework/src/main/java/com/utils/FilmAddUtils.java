package com.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmAddUtils {
        private String userName;
        private String  year;
        private String grade;
        private String showTime;
        private String runTime;
        private List<String> categoryList;
        private String notion;//上映地点
        private String language;
        private String director;
        private String synopsis;
        private List<String> actorList;
        public FilmAddUtils strToFilms(String str){
           return start(testToFilmObject(str));
        }
        public List<String> testToFilmObject(String str) {
            List<String> list = new ArrayList<>();
            for(String s : str.split("\n",10)){
                list.add(s);
            }
            List<String> collect = list.stream()
                    .map(s -> s.substring(3))
                    .collect(Collectors.toList());
            return collect;
        }

        public FilmAddUtils start(List<String> list) {

            Map<String,String> map = nameYearGrade(list.get(0));
            String name = map.get("name");
            String year = map.get("year");
            String grade = map.get("grade");
            //  1
            String showTime = splitLast(list.get(2));//去除最后一个空格
            String runTime = splitLast(list.get(3));//去除最后一个空格
            List<String> categoryList = stringToList(list.get(4));
            String notion = splitLast(list.get(5));//去除最后一个空格
            String language = splitLast(list.get(6));//去除最后一个空格
            String director = splitLast(list.get(7));//去除最后一个空格
            List<String> actorList = stringToList(list.get(8));
            String synopsis = list.get(9);
            return new FilmAddUtils(name,year,grade,showTime,runTime,categoryList,notion,language,director,synopsis,actorList);

        }
        public Map<String,String> nameYearGrade(String str){
            //宇宙探索编辑部（2021）8.4分 ==>["宇宙探索编辑部","2021","8.4"]
            List<String> list = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            for (String s:str.split("（")){
                list.add(s);
            }
            String name = list.get(0);
            String yearGrade = list.get(1);
            for (String s:yearGrade.split("）")){
                list.add(s);
            }
            String year = list.get(2);
            String grade = list.get(3).substring(0,list.get(3).length()-1);
            map.put("name",name);
            map.put("year",year);
            map.put("grade",grade);
            return map;
        }
        public List<String> stringToList(String str) {
            //除去字符串中的空格
            List<String> list = new ArrayList<>();
            for(String s:str.split(" ")){
                list.add(s);
            }
            return list;
        }

        public String splitLast(String str) {
            //除去字符串最后的空格
           return str.substring(0,str.length()-1);
        }

    }