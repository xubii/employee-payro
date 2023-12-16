package com.example.payroll.controller;

import com.example.payroll.dto.EmployeeDetailsRequestDto;
import com.example.payroll.dto.EmployeeDetailsResponseDto;
import com.example.payroll.model.EmployeeDetails;
import com.example.payroll.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping()
    public EmployeeDetailsResponseDto saveEmployeeDetails(@Valid @RequestBody EmployeeDetailsRequestDto employeeDetails) {
           return payrollService.saveEmployeeDetails(employeeDetails.mapTo());
    }

    @GetMapping("/employees-detail")
    public List<EmployeeDetailsResponseDto> getAllEmployeeDetails() {
       return payrollService.getAllEmployeeDetails();
    }

}

