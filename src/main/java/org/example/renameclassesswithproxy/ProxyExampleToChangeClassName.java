package org.example.renameclassesswithproxy;

import java.lang.reflect.Proxy;

public class ProxyExampleToChangeClassName {
    public static void main(String[] args) {

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class<?>[] {MyInterface.class},
                myInvocationHandler
        );
        proxyInstance.myMethod();
    }
}
