package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Cinemas)表实体类
 *
 * @author makejava
 * @since 2023-04-15 10:33:49
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cinemas")
public class Cinemas  {
    //影院id    
    @TableId
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

