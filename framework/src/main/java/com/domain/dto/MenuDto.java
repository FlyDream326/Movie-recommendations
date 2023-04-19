package com.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fly
 * @create 18:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long id;
    private String menuName;
    private Long parentId;
}

