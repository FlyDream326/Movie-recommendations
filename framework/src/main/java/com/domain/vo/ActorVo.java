package com.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorVo {
    //演员名字
    private String name;
    //扮演的角色
    private String role;
    //演员照片URL
    private String avataraddress;

}
