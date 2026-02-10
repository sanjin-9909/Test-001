package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源映射配置：让前端能访问上传的图片
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 必须和 FileController 中的 UPLOAD_ROOT_PATH 一致
    private static final String UPLOAD_ROOT_PATH = "D:/springboot_upload/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射规则：访问 /upload/xxx.jpg → 指向 D:/springboot_upload/xxx.jpg
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + UPLOAD_ROOT_PATH);
    }
}