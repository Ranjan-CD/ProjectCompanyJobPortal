package com.project.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspects {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspects.class);

    //@Around("execution(* com.project.JobApp.service.getJob(..)) && args(postId)")
    @Around("execution(* com.project.JobApp.service..*.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("postId is negative, we are updating it for you");
            postId=-postId;
            LOGGER.info("new value "+postId);
        }

        Object obj=jp.proceed(new Object[]{postId});
        return obj;
    }

}
