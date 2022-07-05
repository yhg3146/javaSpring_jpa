package com.example.part3_practice.ch05.Aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.part3_practice.ch05.Aop.controller..*.*(..))")
    private void cut(){};

//    @Before("cut()")
    private void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());


        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " +obj);
        }

    }

    @AfterReturning(value="cut()",returning = "returnObj")
    private void afterReturning(JoinPoint joinPoint,Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }

}
