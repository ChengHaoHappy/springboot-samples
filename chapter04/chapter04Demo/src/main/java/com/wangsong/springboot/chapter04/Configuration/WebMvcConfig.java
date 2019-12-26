package com.wangsong.springboot.chapter04.Configuration;

import com.wangsong.springboot.chapter04.Interceptor.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 拦截器配置类
 * @author: chenghao
 * @date: 2019/8/19
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1())
                .addPathPatterns("/**")
                .excludePathPatterns("/books")
                .excludePathPatterns("/hello")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/getUser")
                .excludePathPatterns("/deleteUser");
    }

    //通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
