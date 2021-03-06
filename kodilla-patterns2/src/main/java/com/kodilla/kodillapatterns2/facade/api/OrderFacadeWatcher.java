package com.kodilla.kodillapatterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("Logging the event");
    }
    //lub:
    // @Before("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..))"
    // + "&& args(userId) && target(order)")
    // public void logEvent(Long userId, OrderDto order) {
    //     LOGGER.info("Class: " + order.getClass().getName() + ", Args: " + userId);
//      }

    @Around("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @AfterThrowing(value = "execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) throws Throwable {
        LOGGER.error("Aspect: exception: " +  exception.getMessage());
    }
}
