package com.xiong.shop_goods;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xiong")
@DubboComponentScan("com.xiong.serviceImpl")
@MapperScan("com.xiong.dao")
public class ShopGoodsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopGoodsApplication.class, args);
	}
	
}
