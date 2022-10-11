package com.example.demo.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author czh
 * @version 1.0
 * @date 2022/10/10 22:28
 */
@Aspect
@Component
@Slf4j
public class MyAspect {
    private Logger logger = LoggerFactory.getLogger(MyAspect.class);
    @Pointcut(value = "execution(* com.example.demo.controller.Hello1controller.test2(..) )")
    public void myPoincut(){}
    @Around("myPoincut()")
    public Object mylogger(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getName();
        String methName = pjp.getSignature().getName();
        Object param = pjp.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("调用前"+className+""+methName+"请求参数："+objectMapper.writeValueAsString(param));
        Object ob = pjp.proceed();
        logger.info("调用后"+className+""+methName+"返回参数："+objectMapper.writeValueAsString(ob));
        return ob;
    }
}
