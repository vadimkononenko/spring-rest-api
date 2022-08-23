package com.vadimkononenko.springrestapi.service;

import com.vadimkononenko.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeeByNameAndLocation(String name, String location);

    List<Employee> getEmployeeByKeyword(String name);
}
