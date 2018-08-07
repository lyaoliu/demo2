package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/02 下午 4:44
 */
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.example.demo.HelloController..*(..))")
    public void method() throws Throwable {
        System.out.println("aspect");
    }
    @Before("method()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知-----");
        System.out.println(joinPoint.getArgs());
    }
    @After("method()")
    public void after(){
        System.out.println("后置通知-----");
    }
    @Around("method()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("前置通知2-------");
        point.proceed();
        System.out.println("后置通知2-------");
    }

}
