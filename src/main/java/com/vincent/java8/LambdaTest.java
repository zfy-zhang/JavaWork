package com.vincent.java8;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: JavaWork
 * @BelongsPackage: com.vincent.java8
 * @Author: alisha
 * @CreateTime: 2019-01-17 09:56
 * @Description: Lambda测试类
 */
public class LambdaTest {

    /**
     * 匿名内部类
     */
    @Test
    public void testOne() {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    /**
     *  Lambda表达式
     */
     @Test
    public void testTow() {
         Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
         TreeSet<Integer> treeSet = new TreeSet<>(comparator);
     }

     List<Employee> employees = Arrays.asList(
             new Employee("张三丰", 140, 2000000.00),
             new Employee("张无忌", 30, 10000.99),
             new Employee("赵敏", 28, 8000.33),
             new Employee("灭绝", 70, 6000.44),
             new Employee("路人甲", 23, 5000.99),
             new Employee("路人乙", 22, 4400.9)
     );

     public List<Employee> filterEmployees(List<Employee> list) {
         List<Employee> employees = new ArrayList<>();
         for (Employee employee : list) {
            if (employee.getAge() > 40) {
                employees.add(employee);
            }
         }
         return employees;
     }

     

    /**
     *
     */
    @Test
    public void testThree() {
        List<Employee> list = filterEmployees(employees);
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    public List<Employee> filterEmployeeSalary(List<Employee> emps) {
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getSalary() >= 5000){
                list.add(emp);
            }
        }
        return list;
    }


    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> employees = new ArrayList<>();
        for (Employee e : list) {
            if (myPredicate.test(e)) {
                employees.add(e);
            }
        }
        return employees;
    }

    /**
     * 优化方法：调用策略模式
     */
    @Test
    public void testFour() {
        List<Employee> list = filterEmployee(employees, new FilterEmployeeForAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("----------------------------------");

        List<Employee> list1 = filterEmployee(employees, new FilterEmployeeForSalary());
        for (Employee employee : list1) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方法：匿名内部类
     */
    @Test
    public void testFive() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() >= 7000;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方法：Lambda表达式
     */
    @Test
    public void testSix() {
        List<Employee> list = filterEmployee(employees,(e) -> e.getSalary() >= 7000);
        list.forEach(System.out::println);
    }

    /**
     * 优化方法：Stream API
     */
    @Test
    public void testSeven() {
        employees.stream()
                .filter((e -> e.getSalary() >= 7000))
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        employees.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }


}
