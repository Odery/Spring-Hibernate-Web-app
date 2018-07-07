package com.springwebapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("com.springwebapp.aspect.PointcutAspect.forAppFlow()")
    public void beforeAppMethods(JoinPoint joinPoint) {
        logger.info("Running method: " + joinPoint.getSignature().toShortString() +
                " - arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "com.springwebapp.aspect.PointcutAspect.forAppFlow()", returning = "object")
    public void afterReturning(JoinPoint joinPoint, Object object) {
        logger.info("Successful method execution: " + joinPoint.getSignature().toShortString() +
                "- returning value: " + object);
    }
}
