package com.project.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    // Adjust this pointcut to match your desired package/methods
    @Around("execution(* com.project.JobApp.service..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // Proceed with the method execution

        long duration = System.currentTimeMillis() - start;
        String methodName = joinPoint.getSignature().toShortString();

        LOGGER.info("{} executed in {} ms", methodName, duration);

        return result;
    }
}
