package com.fcc.springboot2.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 22:23 2018/11/30
 */
public class EnvConfig {
    @Autowired
    private Environment env;
    @Bean("currentEnvironment")
    //dev环境使用
    @Profile({"dev"})
    public String getCurrentEnvironment(){
        String[] activeProfiles=env.getActiveProfiles();
        return env.getProperty("api.no",String.class);
    }
}
