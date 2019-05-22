package com.pjqdyd.hello.dubbo.service.user.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pjqdyd.hello.dubbo.service.user.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 使用Reference远程调用提供者实现的版本的service
     */
    @Reference(version = "${user.service.version}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hiError")//当调用提供者的方法多次出现异常时,触发熔断,跳入hiError方法
    @GetMapping("/hi")
    public String sayHi(){
        //返回提供者实现的方法
        return userService.sayHi();
    }


    /**
     * Hystrix触发熔断后的回调方法
     * @return
     */
    public String hiError(){
        return "Hystrix Effect";
    }
}
