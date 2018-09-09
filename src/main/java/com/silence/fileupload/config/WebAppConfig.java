package com.silence.fileupload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author silence
 * @version 1.0
 * @className WebAppConfig
 * @date 2018/09/08 下午10:20
 * @description
 * @program file-save2Disk
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${save2Disk-dir}")
    String uploadDir;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
        .addResourceLocations(uploadDir);
    }
}
