package com.example.demo.config;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.ISpringWebFluxTemplateEngine;
import org.thymeleaf.spring5.view.reactive.ThymeleafReactiveViewResolver;

@Configuration
@EnableConfigurationProperties(ThymeleafProperties.class)
public class ReactiveThymeleafConfig {

    private final ISpringWebFluxTemplateEngine templateEngine;

    public ReactiveThymeleafConfig(ISpringWebFluxTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Bean
    public ThymeleafReactiveViewResolver thymeleafChunkedAndDataDrivenViewResolver() {
        ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setOrder(1);

        return viewResolver;
    }

}
