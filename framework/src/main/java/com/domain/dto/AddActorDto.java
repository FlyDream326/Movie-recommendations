package com.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fly
 * @create 21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddActorDto {
    //演员名字
    private String name;
    //扮演的角色
    private String role;
    //演员照片URL
    private String avataraddress;
}
