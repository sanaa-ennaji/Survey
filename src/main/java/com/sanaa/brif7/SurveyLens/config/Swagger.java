package com.sanaa.brif7.SurveyLens.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI() {
        Info apiInfo = new Info()
                .title("SurveyLens API")
                .version("1.0")
                .description("SurveyLens API Documentation");

        return new OpenAPI().info(apiInfo);
    }
}
