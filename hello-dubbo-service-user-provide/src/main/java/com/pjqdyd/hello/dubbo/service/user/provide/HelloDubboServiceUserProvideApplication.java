package com.pjqdyd.hello.dubbo.service.user.provide;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class HelloDubboServiceUserProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloDubboServiceUserProvideApplication.class, args);
        Main.main(args);
    }

}
