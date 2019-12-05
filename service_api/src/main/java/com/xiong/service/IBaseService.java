package com.xiong.service;

import com.xiong.entity.Goods;

import java.util.List;

public interface IBaseService<T> {
	
	List<T> list(T t);	//选择性根据条件查询
	
	List<Goods> getDetailedList(T t);
	
	T queryById(Integer id);
	
	int insert(T t);
}
