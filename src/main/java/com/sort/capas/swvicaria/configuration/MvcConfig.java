package com.sort.capas.swvicaria.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //en esta ruta se guardaran recursos que sean subidos
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:C:/Temp/uploads/");
    }
}
