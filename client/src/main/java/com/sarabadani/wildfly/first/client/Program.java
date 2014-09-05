package com.sarabadani.wildfly.first.client;

import com.sarabadani.wildfly.MyEJB;
import com.sarabadani.wildfly.MyEJBImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by SOROOSH on 9/4/14.
 */
public class Program {
    private final static java.util.logging.Logger logger = Logger.
            getLogger(Program.class.getName());
    private final static Hashtable jndiProperties = new Hashtable();

    public static void main(String... args) throws NamingException {
        Logger.getLogger("org.jboss").setLevel(Level.ALL);
        Logger.getLogger("org.xnio").setLevel(Level.ALL);
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);

        final Context context = new InitialContext(jndiProperties);
//        System.out.println( context.getEnvironment());
        MyEJB myEjb =   (MyEJB)context.lookup("ejb:/First-Web//MyEJBImpl!com.sarabadani.wildfly.MyEJB");
        System.out.println(myEjb.sayHello());

    }
}
