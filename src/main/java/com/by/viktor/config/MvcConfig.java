package com.by.viktor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/services").setViewName("services");
        registry.addViewController("/connect").setViewName("connect");
        registry.addViewController("/connect/request").setViewName("connect");
    }

    public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
        handlerRegistry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
