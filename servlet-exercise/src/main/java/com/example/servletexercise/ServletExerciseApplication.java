package com.example.servletexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServletExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletExerciseApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean exampleServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new HelloServlet(), "/*");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
