package com.wangsong.springboot.chapter04.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

/**
 * @description:自定义配置消息转发器
 * @author: chenghao
 * @date: 2019/8/18
 */
@Configuration
public class GsonConfig {

    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-mm-dd");
        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);//解析修饰符时把protected去掉
        Gson gson = builder.create();
        converter.setGson(gson);
        return converter;
    }

}
