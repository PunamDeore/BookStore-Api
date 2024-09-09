package com.BookStore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bookstore Management API")
                        .version("1.0")
                        .description("API documentation for the Bookstore Management System.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("Punam Deore")
                                .email("punamdeore97@gmail.com")
                                .url("https://github.com/punamdeore"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
