package com.example.configuration;

import com.example.beans.HisBean;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyConfiguration {

    @Bean
    public HisBean hisBean() {
        return new HisBean();
    }

}
