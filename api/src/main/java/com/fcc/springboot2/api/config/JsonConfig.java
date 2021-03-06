package com.fcc.springboot2.api.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fcc.springboot2.api.pojo.dto.out.BaseOutDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.BackingStoreException;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 21:07 2018/11/30
 */
public class JsonConfig {

    @Bean
    //Primary可以理解为默认优先选择,同时不可以同时设置多个
    @Primary
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        AnnotationIntrospector intr = new JacksonAnnotationIntrospector();
        mapper.setAnnotationIntrospector(intr);
        return mapper;
    }

    @Bean
    public BaseOutDto  getBase(){
        BaseOutDto out=new BaseOutDto();
        out.setCreateAt(new Date());
        return out;
    }
}
