package com.example.springboot.exception.map.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.exception.map.mapper.GoodsMapper;
import com.example.springboot.exception.map.object.GoodsDO;
import com.example.springboot.exception.map.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, GoodsDO> implements GoodsService {
}
