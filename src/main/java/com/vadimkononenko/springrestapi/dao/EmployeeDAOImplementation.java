package com.vadimkononenko.springrestapi.dao;

import com.vadimkononenko.springrestapi.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAOImplementation {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getAll() {
        return entityManager
                .createNamedQuery("getAllRecords", Employee.class)
                .getResultList();
    }
}
