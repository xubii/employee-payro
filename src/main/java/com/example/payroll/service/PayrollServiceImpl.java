package com.example.payroll.service;

import com.example.payroll.dto.EmployeeDetailsResponseDto;
import com.example.payroll.exception.BusinessException;
import com.example.payroll.model.EmployeeDetails;
import com.example.payroll.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// PayrollServiceImpl.java
@Service
public class PayrollServiceImpl implements PayrollService {

    private final EmployeeDetailsRepository employeeDetailsRepository;

    public PayrollServiceImpl(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    @Override
    public EmployeeDetailsResponseDto saveEmployeeDetails(EmployeeDetails employeeDetails) {
        try {
            BigDecimal taxAmount = calculateTaxAmount(employeeDetails);
            BigDecimal pensionAmount = calculatePensionAmount(employeeDetails);

            BigDecimal netSalary = employeeDetails.getGrossSalary().subtract(taxAmount).subtract(pensionAmount);

            Optional.ofNullable(employeeDetails.getAdditionalBenefit())
                    .ifPresent(netSalary::add);

            employeeDetails.setNetSalary(netSalary);
            employeeDetails = employeeDetailsRepository.save(employeeDetails);

            return new EmployeeDetailsResponseDto().mapTo(employeeDetails);
        } catch (Exception exception) {
            throw new BusinessException("Exception occured from business layer", exception);
        }
    }

    @Override
    public List<EmployeeDetailsResponseDto> getAllEmployeeDetails() {
        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepository.findAll();

       return employeeDetailsList
                .stream()
                .map(employeeDetail -> new EmployeeDetailsResponseDto().mapTo(employeeDetail))
                .collect(Collectors.toList());

    }

    private BigDecimal calculateTaxAmount(EmployeeDetails employeeDetails) {
        return employeeDetails.getGrossSalary()
                .multiply(employeeDetails.getTaxPercentage().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    }

    private BigDecimal calculatePensionAmount(EmployeeDetails employeeDetails) {
        return employeeDetails.getGrossSalary()
                .multiply(employeeDetails.getPensionPercentage().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    }
}

