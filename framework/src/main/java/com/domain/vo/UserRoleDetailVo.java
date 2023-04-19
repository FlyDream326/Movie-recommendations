package com.domain.vo;


import com.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDetailVo {
   private List<String> roleIds;
   private List<Role> roles;
   private UserInfoVo user;
}