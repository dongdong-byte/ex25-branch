package com.kim.ex25_branch.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j //내가 로그하면 로그 문장을 자동으로 만들어줘(ex)log.info)
@Aspect //이안에 aop구현을 하겠다 일종에 사이드 기능 횡단보도하고 비슷
@Component
public class LoggingAspect {

//서비스 클래스가 실행되기전
    @Before("execution( * com.kim.ex25_branch.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        log.info("MMMMM메서드 실행전 : {} MMMMMMMM",joinPoint.getSignature());



    }
//    서비스가 싫행되고 성공했을때 뜨는것
    @AfterReturning(pointcut = "execution(* com.kim.ex25_branch.service.*.*(..))", returning = "result")
public void  logAfter(JoinPoint joinPoint, Object result){
        log.info("ㅋㅋㅋㅋㅋㅋㅋㅋㅋ메서드 실행성공 : {} Mㅎㅎㅎㅎㅎ", joinPoint.getSignature(),result);

}

}
