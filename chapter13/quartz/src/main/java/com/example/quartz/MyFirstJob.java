package com.example.quartz;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created By ChengHao On 2020/1/21
 */
@Component
public class MyFirstJob {
    public void sayHello() {
        System.out.println("MyFirstJob:sayHello:"+new Date());
    }
}
