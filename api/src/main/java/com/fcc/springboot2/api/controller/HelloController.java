package com.fcc.springboot2.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:37 2018/11/30
 */
//spring mvc注解表明此类用于处理web请求
@Controller
//映射url
@RequestMapping("fcc/hello")
public class HelloController {


    //consumes接收的媒体类型，对应HTTP的content-type
    //produces响应的媒体类型，对应HTTP的Accpet(accept中要有)，同时决定内容类型
    @RequestMapping(value="world",
            method = RequestMethod.GET,
            consumes = "text/html;charset=UTF-8",
            params="action=update",
            headers = "version=1.0")
    //返回是文本，不是视图
    @ResponseBody
    public String hello(){
        return "hello world";
    }
}
