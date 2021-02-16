package com.aijiang.card.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger 配置类
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    
    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("接口文档")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .version("0.0.1")
                        .build())
                .groupName("开发版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aijiang.card.facade.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

