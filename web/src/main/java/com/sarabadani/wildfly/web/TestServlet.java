package com.sarabadani.wildfly.web;

import com.sarabadani.wildfly.AsyncTask;
import com.sarabadani.wildfly.MyEJB;


import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by soroosh on 9/6/14.
 */
public class TestServlet extends HttpServlet {
    @EJB
    private MyEJB myEJB;

    @EJB
    private AsyncTask asyncTask;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + myEJB.sayHello() + "</h1>");
        try {
            out.print("<h1>" + asyncTask.sayHelloAsync().get(1, TimeUnit.SECONDS) +"</h1>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
