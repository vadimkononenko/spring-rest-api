package com.vadimkononenko.springrestapi.controller;

import com.vadimkononenko.springrestapi.dao.EmployeeDAOImplementation;
import com.vadimkononenko.springrestapi.model.Employee;
import com.vadimkononenko.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDAOImplementation eDAO;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
//        return employeeRepository.getEmployees();
        return eDAO.getAll();
    }

}
