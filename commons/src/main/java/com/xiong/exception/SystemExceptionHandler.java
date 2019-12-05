package com.xiong.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 如何处理非代码的异常（404）
 */
@Controller
public class SystemExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    public String systemException(HttpServletResponse response){
        //获得错误的状态码
        int status = response.getStatus();

        switch (status){
            case 401:
                return "401";
            case 402:
                return "402";
            case 403:
                return "403";
            case 404:
                return "404";
        }
        return "myerror";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
