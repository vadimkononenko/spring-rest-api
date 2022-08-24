package com.vadimkononenko.springrestapi.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {

    private String name;

    private String department;
    
}
