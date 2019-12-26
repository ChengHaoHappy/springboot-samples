package com.wangsong.springboot.chapter04.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/19
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.wangsong.springboot.chapter04.Service.*.*(..))")
    public void pcl() {
    }

    @Before(value = "pcl()")
    public void befpre(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行");
    }

    @After(value = "pcl()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束.....");
    }

    @AfterReturning(value = "pcl()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值" + result);
    }

    @AfterThrowing(value = "pcl()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出异常" + e);
    }

    @Around("pcl()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("方法执行前");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("方法执行后");

        return object;
    }

}
