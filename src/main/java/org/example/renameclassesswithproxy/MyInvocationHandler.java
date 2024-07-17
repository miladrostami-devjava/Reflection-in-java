package org.example.renameclassesswithproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * But if your goal is to rename classes
 * in order to create new versions of them or change
 * their behavior, you can use other tools and techniques
 * such as Proxies or Bytecode Manipulation Libraries.*/



public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method " + " " + method.getName() + " " + "is called!") ;
        return proxy.getClass();
    }

}

