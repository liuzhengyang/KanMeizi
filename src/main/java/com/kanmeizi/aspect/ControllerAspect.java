package com.kanmeizi.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by liuzhengyang on 2014/12/2.
 */
@Aspect
@Component
public class ControllerAspect{

    @Pointcut("execution(* com.kanmeizi.controller.HomeController.*(..))")
    public void afterControllerMethod(){
    }

    @After("execution(* com.kanmeizi.controller.*.*(..))")
    public void afterMethodInvoke(){
        System.out.println("hello");
    }
}
