package com.example.payroll.configuration;

import com.example.payroll.model.EmployeeDetails;
import com.example.payroll.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// H2DatabaseInit.java
@Component
public class H2DatabaseInit implements CommandLineRunner {

    private final EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public H2DatabaseInit(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    @Override
    public void run(String... args) {
        // Initialize H2 database with sample data
        EmployeeDetails employee = new EmployeeDetails();
        employee.setName("Muhammad Zohaib");
        employee.setDesignation("Software Java Engineer");
        employee.setProjectName("Technical Assessment");
        employee.setGrossSalary(BigDecimal.valueOf(10000));
        employee.setTaxPercentage(BigDecimal.valueOf(20));
        employee.setPensionPercentage(BigDecimal.valueOf(10));
        employee.setAdditionalBenefit(BigDecimal.valueOf(100));
        employee.setNetSalary(BigDecimal.valueOf(100));

        employeeDetailsRepository.save(employee);
    }
}

