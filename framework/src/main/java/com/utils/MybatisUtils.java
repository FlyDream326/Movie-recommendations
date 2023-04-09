package com.utils;

import java.util.ArrayList;
import java.util.List;

public class MybatisUtils {
    //subList手动分页，page为第几页，rows为每页个数
    public static <T> List<T> subList(List<T> list, int page, int rows) throws Exception{
        List<T> listSort  = new ArrayList<>();
        int size=list.size();
        int pageStart= page==1?0:(page-1)*rows;//截取的开始位置
        int pageEnd=size<page*rows?size:page*rows;//截取的结束位置
        if(size>pageStart){
            listSort =list.subList(pageStart, pageEnd);
        }
        //总页数
        int totalPage=list.size()/rows;
        return listSort;
    }
}
