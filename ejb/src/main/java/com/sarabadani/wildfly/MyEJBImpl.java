package com.sarabadani.wildfly;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 * Created by SOROOSH on 9/4/14.
 */

@Stateless
@Remote(MyEJB.class)
public class MyEJBImpl implements MyEJB {
    public String sayHello(){
        return "Hello man!";
    }
}
