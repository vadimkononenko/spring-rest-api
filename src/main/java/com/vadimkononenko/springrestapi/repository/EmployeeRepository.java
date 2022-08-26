package com.vadimkononenko.springrestapi.repository;

import com.vadimkononenko.springrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    @Query(value = "select * from tbl_employee", nativeQuery = true)
    List<Employee> getEmployees();
}
