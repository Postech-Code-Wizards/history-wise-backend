package br.com.foodwise.platform.infrastructure.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ErrorConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource  messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("api_errors");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
