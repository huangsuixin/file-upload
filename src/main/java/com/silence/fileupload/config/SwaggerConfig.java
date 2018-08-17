package com.silence.fileupload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author suixin
 * @version 1.0
 * @className SwaggerConfig
 * @date 2018/7/17 9:56
 * @description swagger配置
 * @program framework-resource-service
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket restfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Silence")
                .apiInfo(initApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.silence.fileupload"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo initApiInfo() {
        return new ApiInfoBuilder()
                .title("文件上传")
                .description("文件上传服务")
                .version("1.0.0")
                .build();
    }
}
