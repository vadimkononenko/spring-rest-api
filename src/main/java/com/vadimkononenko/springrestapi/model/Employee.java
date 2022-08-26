package com.vadimkononenko.springrestapi.model;

import com.vadimkononenko.springrestapi.request.EmployeeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Employee(EmployeeRequest req) {
        this.name = req.getName();
    }

}
