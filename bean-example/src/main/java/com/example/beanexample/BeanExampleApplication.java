package com.example.beanexample;

import com.example.beans.HisBean;
import com.example.beans.MyBean;
import com.example.beans.YourBean;
import com.example.configuration.MyConfiguration;
import com.example.configuration.YourConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.example.beans"})
@Import({MyConfiguration.class, YourConfiguration.class})
public class BeanExampleApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(BeanExampleApplication.class, args);

        MyBean myBean = applicationContext.getBean(MyBean.class);
        String s1 = myBean.myMethod();
        System.out.println(s1);

        YourBean yourBean = applicationContext.getBean(YourBean.class);
        String s2 = yourBean.yourMethod();
        System.out.println(s2);

        HisBean hisBean = applicationContext.getBean(HisBean.class);
        String s3 = hisBean.hisMethod();
        System.out.println(s3);
    }

}
