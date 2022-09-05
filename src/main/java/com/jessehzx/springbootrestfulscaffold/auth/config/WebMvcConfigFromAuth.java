package com.jessehzx.springbootrestfulscaffold.auth.config;

import com.jessehzx.springbootrestfulscaffold.auth.annotation.resolver.AuthResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author huangzx
 */
@Configuration
public class WebMvcConfigFromAuth implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(authResolver());
    }

    @Bean
    public AuthResolver authResolver() {
        return new AuthResolver();
    }
}
