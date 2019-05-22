package com.pjqdyd.hello.dubbo.service.user.provide.api.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pjqdyd.hello.dubbo.service.user.api.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * 实现在接口项目中的UserService
 */
@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.protocol.port}")
    private String port;


    //在方法上实现熔断,后面的属性可以不填,默认的阈值是消费者5秒中调用方法20次不可用(有异常抛出/超时),消费者触发熔断
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public String sayHi(){
        return "Hello Dubbo, I am from port:" + port;
        //throw new RuntimeException("Exception to show hystrix enabled");//模拟异常
    }
}
