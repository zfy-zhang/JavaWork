package com.vincent.java8;

/**
 * @BelongsProject: JavaWork
 * @BelongsPackage: com.vincent.java8
 * @Author: alisha
 * @CreateTime: 2019-01-17 10:44
 * @Description: FilterEmployeeForSalary
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 7000;
    }
}
