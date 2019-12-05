package com.xiong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiong.entity.Goods;
import com.xiong.entity.ResultData;
import com.xiong.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    
    @Reference
    IGoodsService goodsService;
    
    @RequestMapping("/list")
    public String list(Model model){
    
        List<Goods> goodsList = goodsService.getDetailedList(null);
        model.addAttribute("goodsList", goodsList);
    
        return "goodslist";
    }

    
    @RequestMapping("/insert")
    public String insert(Goods goods){
        
        goodsService.insert(goods);
        return "redirect:/goods/list";
    }
    
    
    
    @RequestMapping("/ajax")
    @ResponseBody
    public ResultData<String> ajax(){
        int a = 1/0;
        return new ResultData<String>()
                .setCode(ResultData.ResultCodeList.OK)
                .setData("MyData");
    }
    
    @RequestMapping("/test")
    public String test(){
        return "fileupload_test";
    }
}
