package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Film;
import com.mapper.FilmMapper;
import com.service.FilmService;
import org.springframework.stereotype.Service;

/**
 * (Film)表服务实现类
 *
 * @author makejava
 * @since 2023-04-05 15:27:14
 */
@Service("filmService")
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements FilmService {

}

