package com.kim.ex25_branch.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    서비스 클래스가 실행되기전
@Before( "execution(* com.kim.ex25_branch.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
    log.info("mmmmmm메서드 실행전 :{} mmmmmmmmm",joinPoint.getSignature());
//    서비스가 실행되고 성공했을때 뜨는것

}
    @AfterReturning(pointcut = "execution(* com.kim.ex25_branch.service.*.*(..)",returning = "result")
    public void logAfter(JoinPoint joinPoint , Object result ){
    log.info("mmmmmm메서드 실행후 :{} mmmmmmmmm",joinPoint.getSignature(),result);
    }

}
