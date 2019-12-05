package com.xiong.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GoodsPicture extends BaseEntity {
	
	private Integer gid;    //商品id
	private String url;     //图片地址
	private String description;     //图片描述
	private Integer isCover;        //1-封面  0-封面
	
}
