package com.example.springboot.exception.map.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.exception.map.object.GoodsDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<GoodsDO> {
}
