package com.vadimkononenko.springrestapi.controller;

import com.vadimkononenko.springrestapi.model.Employee;
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
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
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

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(
            @RequestParam String name,
            @RequestParam String location) {
        return new ResponseEntity<>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<>(employeeService.getEmployeeByKeyword(name), HttpStatus.OK);
    }

    @GetMapping("employees/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(
            @PathVariable String name,
            @PathVariable String location) {
        return new ResponseEntity<>(employeeService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
    }

}
