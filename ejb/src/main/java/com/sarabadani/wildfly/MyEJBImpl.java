package com.sarabadani.wildfly;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

/**
 * Created by SOROOSH on 9/4/14.
 */

@Stateless
@Remote(MyEJB.class)
public class MyEJBImpl implements MyEJB {
    @Resource
    TimerService timerService;
    long duration=6000;

    @PostConstruct
    public void createTimer(){
        System.out.println("Initializing EJB!");
    }


//    @Schedule(dayOfWeek = "*", hour = "*", minute = "*", second =
//            "*",year="*", persistent = false)
//    public void schedule(){
//        System.out.println("Haha");
//    }


    public String sayHello(){
//        timerService.createSingleActionTimer(duration,new TimerConfig());
        return "Hello man!";
    }

    @Timeout
    public void timeout(){
        System.out.println("Time out!!!");
    }
}
