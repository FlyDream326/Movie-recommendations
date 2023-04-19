package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.dto.AddActorDto;
import com.entity.Actor;
import com.enums.AppHttpCodeEnum;
import com.mapper.ActorMapper;
import com.service.ActorService;
import com.utils.BeanCopyUtils;
import com.utils.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * (Actor)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:31:24
 */
@Service("actorService")
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor> implements ActorService {

    // 单个演员信息添加
    @Override
    public ResponseResult addActor(AddActorDto dto) {

        // 查询演员信息是否已存在
        String name = dto.getName();
        if(isActorExist(name)){
            return ResponseResult.errorResult(AppHttpCodeEnum.ACTOR_INFO_EXIST);
        }
        // 不存在 添加演员信息
        Actor actor = BeanCopyUtils.copyBean(dto, Actor.class);
        save(actor);
        return ResponseResult.okResult();
    }

    /**
     * 工具类 根据传入的name属性查询演员是否存在
     *
     * @param name
     * @return 存在返回 true ,否则返回false
     */
    private boolean isActorExist(String name) {
        LambdaQueryWrapper<Actor> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(Actor::getName,name);

        return count(queryWrapper)>0;
    }
}

