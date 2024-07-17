package org.example.bytebuddyforchangebytecodeclass;


import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**Using Byte Buddy
 * to change the bytecode of a class*/
public class ByteBuddyExample {
    public static void main(String[] args) throws
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        Class<?> dynamicByte = new ByteBuddy()
                .subclass(Object.class)
                .name("org.example.DynamicClassMilad")
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello Java Developer to change class name and internal content and structure"))
                .make()
                .load(ByteBuddyExample.class.getClassLoader(),
                        ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        Constructor<?> defaultConstructor  = dynamicByte.getConstructor();
        Object instance = defaultConstructor.newInstance();
        System.out.println("the result is :" + " " + instance.toString());


    }
}
