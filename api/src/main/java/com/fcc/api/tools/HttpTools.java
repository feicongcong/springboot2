package com.fcc.api.tools;

import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:47 2018/7/28
 */
public class HttpTools {

    public static Map<String, Object> restTemplateDoGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(url, HashMap.class);
        Map<String, Object> map = Maps.newHashMap();
        map.put("statusCode", responseEntity.getStatusCode());
        map.put("responseBody", responseEntity.getBody());
        return map;
    }

    public static Map<String, Object> restTemplateDoPost(String url, String jsonStr) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, jsonStr, HashMap.class);
        Map<String, Object> map = Maps.newHashMap();
        map.put("statusCode", responseEntity.getStatusCode());
        map.put("responseBody", responseEntity.getBody());
        return map;
    }

}
