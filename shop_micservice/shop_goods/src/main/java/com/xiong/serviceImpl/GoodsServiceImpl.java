package com.xiong.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiong.dao.IGoodsDao;
import com.xiong.dao.IGoodsImageDao;
import com.xiong.entity.Goods;
import com.xiong.entity.GoodsPicture;
import com.xiong.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {
	
	@Autowired
	IGoodsDao goodsDao;
	@Autowired
	IGoodsImageDao goodsImageDao;
	
	@Override
	public List<Goods> list(Goods goods) {
		List<Goods> goodsList = goodsDao.selectList(null);
		return goodsList;
	}
	
	/**
	 * 联表查封面和图片集
	 */
	@Override
	public List<Goods> getDetailedList(Goods goods) {
		List<Goods> detailedList = goodsDao.getDetailedList(null);
		System.out.println(detailedList);
		return detailedList;
	}
	
	@Override
	public Goods queryById(Integer id) {
		return null;
	}
	
	@Override
	public int insert(Goods goods) {
		//添加商品
		goodsDao.insert(goods);
		
		//添加封面
		GoodsPicture goodsPicture = new GoodsPicture().setGid(goods.getId()).setIsCover(1).setUrl(goods.getCoverImg());
		goodsImageDao.insert(goodsPicture);
		
		//添加其他图片
		for (String otherImg : goods.getOtherImgs()) {
			GoodsPicture picture = new GoodsPicture().setGid(goods.getId()).setIsCover(1).setUrl(goods.getCoverImg());
			goodsImageDao.insert(picture);
		}
		
		return 1;
	}
}
