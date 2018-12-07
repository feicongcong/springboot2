package com.fcc.springboot2.api;

import com.fcc.springboot2.api.config.EnvConfig;
import com.fcc.springboot2.api.config.JsonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:30 2018/11/30
 */
@Import({
        // json配置
        JsonConfig.class,
        EnvConfig.class
        // 数据源配置
//        DataSourceConfig.class,
//        // swagger
//        Swagger2Config.class,
})
@ComponentScan(basePackages = {
        "com.fcc.springboot2.api"
})
//使其成为一个spring boot应用
@SpringBootApplication
public class ApiBoot {

    public static void main(String[] args) {
        //运行这个springboot应用
        SpringApplication.run(ApiBoot.class, args);

    }
}
