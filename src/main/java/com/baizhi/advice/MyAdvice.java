package com.baizhi.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
    @Before(value = "within(com.baizhi.service.*ServiceImpl)")
    public void before1(JoinPoint joinPoint) {
        System.out.println("嘿嘿,我在前边" + 1564854);
    }

    @After(value = "within(com.baizhi.service.*ServiceImpl)")
    public void aftrer1() {
        System.out.println("哈哈,我在后边");
    }
}
