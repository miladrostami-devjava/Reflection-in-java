package org.example;

import java.lang.reflect.Array;

public class Employ {
    private String name;
    private int age;
    @MyAnnotation("this annotation is example for salary parameter")
    private double salary;


    int[] intArray = {5,6,7,8,9,1,2,3,4,5,90,6,89,7};

    public Employ() {
    }

    public Employ(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @MyAnnotation("this annotation is example for getName method")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    private void print(){
        System.out.println("the name is :" + name + " -  " + ",the age is : " + " - " + age + " ,the salary is : " + salary) ;
}

private String loadData(){
        return name + " " + age + " " + salary;
}



}















