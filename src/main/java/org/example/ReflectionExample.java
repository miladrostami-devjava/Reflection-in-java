package org.example;

import java.lang.reflect.*;

/**
 * Hello world!
 *
 */
public class ReflectionExample
{
    public static void main( String[] args )
    {

        try {
            // Access to Employ Class
            Class<?> employClass = Class.forName("org.example.Employ");
            System.out.println("Access to Employ Class " + " " + employClass.getName());


            // Create the object using the default constructor
            Constructor<?> defaultConstructor = employClass.getConstructor();
            Object newEmploy = defaultConstructor.newInstance();
            System.out.println("newEmploy created using default constructor: " + " " + newEmploy);


            //Create object using parameterized constructor
            Constructor<?> parameterizedConstructor = employClass.getConstructor(String.class,int.class,double.class);
            Object newEmployWithParameters = parameterizedConstructor.newInstance("miladRostami",31,18.3);
            System.out.println("Create object using parameterized constructor : " + " " + newEmployWithParameters);


            //Access and change private fields
            Field nameField = employClass.getDeclaredField("name");
            Field ageField = employClass.getDeclaredField("age");
            Field salaryField = employClass.getDeclaredField("2000$");

            //Access to the fields should be set as accessible
            nameField.setAccessible(true);
            ageField.setAccessible(true);
            salaryField.setAccessible(true);

            //Changing the value of fields
            nameField.set(newEmploy,"rezaZare");
            ageField.set(newEmploy,"30");
        salaryField.set(newEmploy,"1850$");

// Display the values of changed fields
            System.out.println("the newEmploy name :" + " "  + nameField.get(newEmploy));
            System.out.println("the newEmploy age :" + " "  + ageField.get(newEmploy));
            System.out.println("the newEmploy salary :" + " "  + salaryField.get(newEmploy));

// access to public methods
            Method setNamePublicMethod = employClass.getMethod("setName", String.class);
            setNamePublicMethod.invoke(newEmploy,"arashTimori");
            System.out.println("setNamePublicMethod  in newEmploy is : " + " " + setNamePublicMethod);

            Method getNamePublicMethod = employClass.getMethod("getName");
String name = (String) getNamePublicMethod.invoke(newEmploy);
            System.out.println("in newEmploy , new name is :" + " " + name);

            // access to private methods
            Method printPrivateMethod = employClass.getMethod("print");
            printPrivateMethod.setAccessible(true);
            printPrivateMethod.invoke(newEmploy);

            Method loadDataPrivateMethod = employClass.getMethod("loadData");
            loadDataPrivateMethod.setAccessible(true);
            printPrivateMethod.invoke(newEmploy);


            // access to Annotation ,AnnotatedElement for method
            Method method =employClass.getMethod("getName");
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value for method " + "  " + annotation.value()) ;

            // access to Annotation ,AnnotatedElement for field
            Field field = employClass.getDeclaredField("salary");
            MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value for field : " + " " + myAnnotation.value());

            //access to array in reflection in class
            int[] intArray = (int[]) Array.newInstance(int.class,13);
            Array.set(intArray,33,23);
            Array.set(intArray,333,233);
            Array.set(intArray,343,253);
            Array.set(intArray,333,2332);
            Array.set(intArray,3133,23132);
            System.out.println("Array[0] is:" + Array.get(intArray,0));
            System.out.println("Array[1] is:" + Array.get(intArray,1));
            System.out.println("Array[2] is:" + Array.get(intArray,2));
            System.out.println("Array[3] is:" + Array.get(intArray,3));


            // Parameter in Reflection Provides information about method or constructor parameters
            Method method1 = employClass.getMethod("setName", String.class);
            Parameter[] parameters = method1.getParameters();
            for (Parameter parameter: parameters) {
                System.out.println("the parameter :" + " " + parameter.getName() + " " + parameter.getModifiers()
                + " " + parameter.getType() + " "  + parameter.getAnnotation(MyAnnotation.class));
            }
















        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }
}
