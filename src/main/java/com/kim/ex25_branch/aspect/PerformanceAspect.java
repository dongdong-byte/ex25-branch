package com.kim.ex25_branch.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {


    @Around("execution( * com.kim.ex25_branch.service.*.*(..))")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();// 시스템이 가지고 있는 천단위를 세라
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("(((((실행시간 : {} )))))))) \n ((((((((({}))))))))))",pjp.getSignature(),(end-start));


        return pjp.proceed();
    }
}
