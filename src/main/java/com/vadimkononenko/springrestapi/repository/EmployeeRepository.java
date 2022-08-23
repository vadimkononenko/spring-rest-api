package com.vadimkononenko.springrestapi.repository;

import com.vadimkononenko.springrestapi.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameAndLocation(String name, String location);

    // SELECT * FROM table WHERE name LIKE "%<pattern>%"
    List<Employee> findByNameContaining(String keyword, Sort sort);
}
