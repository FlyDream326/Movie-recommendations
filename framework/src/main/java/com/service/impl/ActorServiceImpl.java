package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Actor;
import com.mapper.ActorMapper;
import com.service.ActorService;
import org.springframework.stereotype.Service;

/**
 * (Actor)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:31:24
 */
@Service("actorService")
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor> implements ActorService {

}

