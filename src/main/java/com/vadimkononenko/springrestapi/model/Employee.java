package com.vadimkononenko.springrestapi.model;

import com.vadimkononenko.springrestapi.request.EmployeeRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

    public Employee(EmployeeRequest req) {
        this.name = req.getName();
    }

    public Employee() {

    }
}
