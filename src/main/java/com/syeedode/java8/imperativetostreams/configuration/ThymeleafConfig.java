package com.syeedode.java8.imperativetostreams.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Arrays;

/**
 * Author: syeedode
 * Date: 4/5/18
 */
@Configuration
public class ThymeleafConfig {

    @Bean
    public ThymeleafViewResolver templateResolver(SpringTemplateEngine templateEngine) {
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setTemplateMode("HTML5");
        ThymeleafViewResolver templateResolver = new ThymeleafViewResolver();
        templateResolver.setTemplateEngine(templateEngine);
        templateResolver.setOrder(1);
        templateResolver.setViewNames(StringUtils.toStringArray(Arrays.asList("*.htmml")));
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ClassLoaderTemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
}
