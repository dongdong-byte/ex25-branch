package com.kim.ex25_branch.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {


    @Around("execution(* com.kim.ex25_branch.service.*.*(..)")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
//        시스템이 가지고 있는 천단위를 세라
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("ㅎㅎㅎㅎ 실행시간 : {} >>>>> \n rrrr {} rrrr",joinPoint.getSignature(),end-start);
        return joinPoint.proceed();
    }
}
