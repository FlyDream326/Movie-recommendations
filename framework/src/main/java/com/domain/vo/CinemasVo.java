package com.domain.vo;

import com.entity.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fly
 * @create 10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemasVo {

    private District district;

    private Long cinemaid;

    //影院名称
    private String name;
    //影院地址
    private String address;

    private String longitude;

    private String latitude;
    //gps地址
    private String gpsaddress;
    //城市id
    private Long cityid;
    //城市名称
    private String cityname;
    //城区id
    private Integer districtid;
    //城区名称
    private String districtname;
    //移动手机号
    private String phone;
    //手机号
    private String telephones;
    //LOGOURL
    private String logourl;
    //营业时间
    private String businesstime;
    //告示
    private String notice;

    private Integer isvisited;

    private Integer lowprice;
    //距离
    private String distance;

    private String eticketflag;

    private String seatflag;

    private String tickettypes;
}
