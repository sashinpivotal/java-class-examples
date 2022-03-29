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
    public ServletRegistrationBean helloServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new HelloServlet(), "/hello1/*");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean helloServletShowRequestHeadersBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new HelloServletShowRequestHeaders(), "/hello2/*");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
