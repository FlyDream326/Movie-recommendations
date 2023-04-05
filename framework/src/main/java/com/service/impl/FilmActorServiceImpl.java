package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.FilmActor;
import com.mapper.FilmActorMapper;
import com.service.FilmActorService;
import org.springframework.stereotype.Service;

/**
 * (FilmActor)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:31:41
 */
@Service("filmActorService")
public class FilmActorServiceImpl extends ServiceImpl<FilmActorMapper, FilmActor> implements FilmActorService {

}

