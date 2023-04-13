package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Photos;
import com.mapper.PhotosMapper;
import com.service.PhotosService;
import org.springframework.stereotype.Service;

/**
 * (Photos)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 15:40:29
 */
@Service("photosService")
public class PhotosServiceImpl extends ServiceImpl<PhotosMapper, Photos> implements PhotosService {

}

