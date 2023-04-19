package com.controller;

import com.domain.dto.AddActorDto;
import com.domain.vo.ActorVo;
import com.domain.vo.PageVo;
import com.entity.Actor;
import com.service.ActorService;
import com.utils.BeanCopyUtils;
import com.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author fly
 * @create 16:25
 */
@RestController
@RequestMapping("/sys/actor")
public class ActorController {
    // TODO actor vue前台
    @Resource
    private ActorService actorService;

    //获取演员信息列表
    @GetMapping("/list")
    public ResponseResult actorList(){
        List<Actor> list = actorService.list();
        return ResponseResult.okResult(new PageVo(list,new Long(list.size())));
    }
    //获取单个演员信息
    @GetMapping("/{id}")
    public ResponseResult actorOne(@PathVariable("id") Long id){
        return ResponseResult.okResult(actorService.getById(id));
    }


    // 添加单个演员信息
    @PostMapping("/one")
    public ResponseResult addActor(@RequestBody AddActorDto dto){
        return actorService.addActor(dto);
    }
    // 删除多个演员信息
    @DeleteMapping
    public ResponseResult delActors(@RequestBody List<Long> ids){
        actorService.getBaseMapper().deleteBatchIds(ids);
        return ResponseResult.okResult();
    }
    // 删除单个演员信息
    @DeleteMapping("/{id}")
    public ResponseResult delActor(@PathVariable("id") Long id){
        actorService.getBaseMapper().deleteById(id);
        return ResponseResult.okResult();
    }

    /**
     * 演员信息的修改
     * id 不能为空(前端判断)
     * @param dto
     * @return
     */
    @PutMapping
    public ResponseResult upDataActor(@RequestBody ActorVo dto){
        Actor actor = BeanCopyUtils.copyBean(dto, Actor.class);
        actorService.updateById(actor);
        return ResponseResult.okResult();
    }
}
