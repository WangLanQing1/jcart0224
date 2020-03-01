package com.wlq;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
/**
 * @Authof: ZhangYingHao
 * @Date: Create in 16:32 2018/8/8
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/video/**").addResourceLocations("file:C:/Users/WangLanqing/Documents/jcart0224/jcart-administration-back/src/main/resources/static/video/");
        registry.addResourceHandler("/pic/**").addResourceLocations("file:C:/Users/WangLanqing/Documents/jcart0224/jcart-administration-back/src/main/resources/static/pic/");
    }
}