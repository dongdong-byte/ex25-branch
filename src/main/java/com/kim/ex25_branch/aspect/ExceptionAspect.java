package com.kim.ex25_branch.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.kim.ex25_branch.service.*.*(..)",throwing = "exception" )
    public void logError(JoinPoint joinPoint, Exception exception){
        log.info("rrrrrrr 메서중 오류 발생 : {} rrrr \n rrrr {} rrrr",joinPoint.getSignature(),exception.getMessage());
    }
}
