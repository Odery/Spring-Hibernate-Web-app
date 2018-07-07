package com.springwebapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutAspect {

    @Pointcut("within(com.springwebapp.controller..*)")
    public void forController() {
    }

    @Pointcut("within(com.springwebapp.dao..*)")
    public void forDAO() {
    }

    @Pointcut("within(com.springwebapp.entity..*)")
    public void forEntity() {
    }

    @Pointcut("within(com.springwebapp.service..*)")
    public void forService() {
    }

    @Pointcut("forController() || forDAO() || forEntity() || forService()")
    public void forAppFlow() {
    }
}
