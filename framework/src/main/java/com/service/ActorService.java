package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.dto.AddActorDto;
import com.entity.Actor;
import com.utils.ResponseResult;


/**
 * (Actor)表服务接口
 *
 * @author makejava
 * @since 2023-04-05 15:31:24
 */
public interface ActorService extends IService<Actor> {

    ResponseResult addActor(AddActorDto dto);
}

