package com.example.configuration;

import com.example.beans.YourBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YourConfiguration {

    @Bean
    public YourBean yourBean() {
        return new YourBean();
    }
}
