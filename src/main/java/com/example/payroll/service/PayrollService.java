package com.example.payroll.service;

import com.example.payroll.dto.EmployeeDetailsResponseDto;
import com.example.payroll.model.EmployeeDetails;

import java.util.List;

// PayrollService.java
public interface PayrollService {
    EmployeeDetailsResponseDto saveEmployeeDetails(EmployeeDetails employeeDetails);

    List<EmployeeDetailsResponseDto> getAllEmployeeDetails();
}
