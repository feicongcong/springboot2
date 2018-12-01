package com.fcc.api.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 21:15 2018/11/30
 */
public class JsonComponent {
    public static String encode(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = SpringComponent.getBean(ObjectMapper.class);
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T decode(String json, Class<T> classOfT) throws IOException {
        ObjectMapper objectMapper = SpringComponent.getBean(ObjectMapper.class);
        return objectMapper.readValue(json, classOfT);
    }

}
