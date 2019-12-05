package com.xiong.exception;

import com.xiong.entity.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 如何分别处理同步、ajax异步请求
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Exception e){

        String header = request.getHeader("X-Requested-With");
        
        //ajax请求
        if(header != null && header.equals("XMLHttpRequest")){
            return new ResultData<>().setCode(ResultData.ResultCodeList.ERROR).setMsg("服务器走丢了，等下再试试叭！");
            
         //同步请求,返回错误页面
        } else { 
            return new ModelAndView("myerror");
        }
    }
}
