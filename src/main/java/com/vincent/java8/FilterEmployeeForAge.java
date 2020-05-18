package com.vincent.java8;

/**
 * @BelongsProject: JavaWork
 * @BelongsPackage: com.vincent.java8
 * @Author: alisha
 * @CreateTime: 2019-01-17 10:36
 * @Description: FilterEmployeeForAge
 */
public class FilterEmployeeForAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 40;
    }
}
