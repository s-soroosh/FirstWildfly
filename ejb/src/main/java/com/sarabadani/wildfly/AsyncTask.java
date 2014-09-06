package com.sarabadani.wildfly;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import java.util.concurrent.Future;

/**
 * Created by soroosh on 9/6/14.
 */
@Singleton
public class AsyncTask {
    @Asynchronous
    public Future<String> sayHelloAsync() throws InterruptedException {
        Thread.sleep(5000l);
        System.out.println("Returning result...");
        return new AsyncResult<String>("Hello man");
    }
}
