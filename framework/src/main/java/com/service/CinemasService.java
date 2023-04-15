package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.vo.CinemasVo;
import com.entity.Cinemas;


/**
 * (Cinemas)表服务接口
 *
 * @author makejava
 * @since 2023-04-15 10:33:49
 */
public interface CinemasService extends IService<Cinemas> {

    CinemasVo cinemaList();

}

