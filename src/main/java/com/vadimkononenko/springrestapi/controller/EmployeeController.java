package com.vadimkononenko.springrestapi.controller;

import com.vadimkononenko.springrestapi.model.Department;
import com.vadimkononenko.springrestapi.model.Employee;
import com.vadimkononenko.springrestapi.repository.DepartmentRepository;
import com.vadimkononenko.springrestapi.repository.EmployeeRepository;
import com.vadimkononenko.springrestapi.request.EmployeeRequest;
import com.vadimkononenko.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return new ResponseEntity<>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {

        Employee employee = new Employee(eRequest);
        employee = employeeRepository.save(employee);

        for (String s : eRequest.getDepartment()) {
            Department d = new Department();
            d.setName(s);
            d.setEmployee(employee);

            departmentRepository.save(d);
        }

        return new ResponseEntity<>("Record saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
