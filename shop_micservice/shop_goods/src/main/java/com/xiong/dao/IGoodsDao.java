package com.xiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiong.entity.Goods;

import java.util.List;

public interface IGoodsDao extends BaseMapper<Goods> {
	List<Goods> getDetailedList(Goods goods);
}
