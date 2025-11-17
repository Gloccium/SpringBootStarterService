package com.example.greeting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(com.example.greeting.GreetingService.class)
@EnableConfigurationProperties(com.example.greeting.GreetingProperties.class)
public class GreetingAutoConfiguration {

    private final com.example.greeting.GreetingProperties properties;

    public GreetingAutoConfiguration(com.example.greeting.GreetingProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public com.example.greeting.GreetingService greetingService() {
        // Создаем бин, используя настройки из GreetingProperties
        return new com.example.greeting.GreetingService(properties.getPrefix(), properties.getSuffix());
    }
}