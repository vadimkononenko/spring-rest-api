package com.vadimkononenko.springrestapi.repository;

import com.vadimkononenko.springrestapi.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
