package com.example.part3.ch05.AOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.part3.ch05.AOP.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.part3.ch05.AOP.annotation.Timer)")
    private void enableTimer(){}


    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();

        System.out.println("total time : "+stopWatch.getTotalTimeSeconds());
    }
}
