package com.fcc.api.controller;

import com.fcc.api.pojo.dto.in.JsrInDto;
import com.fcc.api.pojo.dto.out.BaseOutDto;
import com.fcc.api.pojo.dto.out.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:44 2018/11/30
 */
//支持restful应用，相当于@Controller+@ResponseBody
@RestController
@RequestMapping("rest")
public class RestHelloController {
    @Autowired
    @Qualifier("currentEnvironment")
    private String env;

    @RequestMapping(value = "hello",
            method = RequestMethod.GET
            )
    public String hello(){
        return "hello world";
    }

    @PostMapping(value = "jsr303")
    public ResultDto jsr(@Validated({JsrInDto.Add.class}) @RequestBody JsrInDto inDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultDto.build("params exception");
        }
        BaseOutDto outDto=new BaseOutDto();
        outDto.setCreateAt(new Date());
        System.out.println(outDto.getCreateAt());
        System.out.println(env);
        return ResultDto.build().setResult(outDto);
    }
}
