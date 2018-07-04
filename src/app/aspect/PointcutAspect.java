package app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutAspect {

    @Pointcut("within(app.controller..*)")
    public void forController() {
    }

    @Pointcut("within(app.dao..*)")
    public void forDAO() {
    }

    @Pointcut("within(app.entity..*)")
    public void forEntity() {
    }

    @Pointcut("within(app.service..*)")
    public void forService() {
    }

    @Pointcut("forController() || forDAO() || forEntity() || forService()")
    public void forAppFlow() {
    }
}
