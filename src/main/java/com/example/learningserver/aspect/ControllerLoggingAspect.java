package com.example.learningserver.aspect;

import com.example.commonaop.mapper.Mapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLoggingAspect {
    @Around("execution(public com.example.learningserver.api.controller.Controller *(..))")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("executing method " + joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        log.info("service input: {}", Mapper.toJson(joinPoint.getArgs()[0]));
        Object response = null;
        try {
            response = joinPoint.proceed();
        } catch (Throwable e) {
            log.info("service throws: " + e);
        }
        long end = System.currentTimeMillis();
        log.info("duration: {} ms", (end - start));
        log.info("service output: {}", Mapper.toJson(response));
        return response;
    }
}
