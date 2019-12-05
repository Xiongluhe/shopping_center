package com.xiong.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class Goods extends BaseEntity{
	
	private String subject;
	private String info;
	private BigDecimal price;
	private Integer save;
	
	@TableField(exist = false)
	private String coverImg;
	
	@TableField(exist = false)
	private List<String> otherImgs;
	
}
