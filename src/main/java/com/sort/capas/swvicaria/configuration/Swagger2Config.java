package com.sort.capas.swvicaria.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.sort.capas.swvicaria.controllers"
                ))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(
                        RequestMethod.GET, Arrays.asList(
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("Ooops! Server Error")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("You have no auth!")
                                        .build()
                        )
                );

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot VicariaSW")
                .description("API Description for VicariaSW")
                .version("1.0.0")
                .contact(new Contact("Sortweste", "github.com", "00123216@uca.edu.sv"))
                .build();
    }

}
