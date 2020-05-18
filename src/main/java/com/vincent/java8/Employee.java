package com.vincent.java8;

/**
 * @BelongsProject: JavaWork
 * @BelongsPackage: com.vincent.java8
 * @Author: alisha
 * @CreateTime: 2019-01-17 10:06
 * @Description: 员工类
 */
public class Employee {

    private String name;
    private int age;
    private Double salary;

    public Employee() {
    }

    public Employee(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
