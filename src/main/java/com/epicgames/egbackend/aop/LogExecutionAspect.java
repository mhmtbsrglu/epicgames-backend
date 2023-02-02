package com.epicgames.egbackend.aop;

import com.epicgames.egbackend.constant.LoggerConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogExecutionAspect {
    @Around("@annotation(com.epicgames.egbackend.annotation.LogExecutionTime)")
    public Object checkSessionState(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        executionTime = executionTime / 1000;
        log.info(String.format(LoggerConstant.GENERAL_LOG_FORMAT,joinPoint.getSignature() + " executed in", executionTime % 60 + "s"));
        return proceed;
    }

}