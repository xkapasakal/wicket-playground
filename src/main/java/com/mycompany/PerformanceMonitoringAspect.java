package com.mycompany;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceMonitoringAspect {
    static final Logger logger = LogManager.getLogger(PerformanceMonitoringAspect.class.getName());

    @Pointcut("execution(* doSomething(..))")
    public void monitoredOp() {
    }

    @Around("monitoredOp()")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long complete = System.nanoTime();
            System.out.println("Inside aspect");
            logger.info(
                "Operation " + pjp.getSignature().toShortString()
                    + " took " + (complete - start) + " nanoseconds");
        }
    }
}
