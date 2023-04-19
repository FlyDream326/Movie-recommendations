package com.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author fly
 * @create 19:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleTreeVo {
    private List menus;
    private List checkedKeys;
}
