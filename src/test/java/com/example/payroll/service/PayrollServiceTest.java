package com.example.payroll.service;

import com.example.payroll.dto.EmployeeDetailsResponseDto;
import com.example.payroll.exception.BusinessException;
import com.example.payroll.model.EmployeeDetails;
import com.example.payroll.repository.EmployeeDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.fail;

@ExtendWith(MockitoExtension.class)
public class PayrollServiceTest {

    @Mock
    EmployeeDetailsRepository employeeDetailsRepository;

    @InjectMocks
   PayrollServiceImpl payrollService;

    @BeforeEach
    public void setUp() {
        payrollService = new PayrollServiceImpl(employeeDetailsRepository);
    }

    @Test
    public void testSaveEmployeeDetails() {
        // Create a sample EmployeeDetails object for testing
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setGrossSalary(BigDecimal.valueOf(10000));
        employeeDetails.setTaxPercentage(BigDecimal.valueOf(20));
        employeeDetails.setPensionPercentage(BigDecimal.valueOf(10));

        // Mock repository save method
        when(employeeDetailsRepository.save(any())).thenReturn(employeeDetails);

        // Call the service method
        EmployeeDetailsResponseDto savedEmployee = payrollService.saveEmployeeDetails(employeeDetails);

        // Assertions
        assertNotNull(savedEmployee);
        assertEquals(BigDecimal.valueOf(7100.00), savedEmployee.getNetSalary());
        verify(employeeDetailsRepository, times(1)).save(employeeDetails);
    }

    @Test
    public void testGetAllEmployeeDetails() {
        // Create a sample list of EmployeeDetails for testing
        List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
        EmployeeDetails employee1 = new EmployeeDetails();
        employee1.setGrossSalary(BigDecimal.valueOf(10000));
        employee1.setTaxPercentage(BigDecimal.valueOf(20));
        employee1.setPensionPercentage(BigDecimal.valueOf(10));
        employeeDetailsList.add(employee1);

        // Mock repository findAll method
        when(employeeDetailsRepository.findAll()).thenReturn(employeeDetailsList);

        // Call the service method
        List<EmployeeDetailsResponseDto> resultList = payrollService.getAllEmployeeDetails();

        // Assertions
        assertNotNull(resultList);
        assertEquals(1, resultList.size());
        assertEquals(BigDecimal.valueOf(7100.00), resultList.get(0).getNetSalary());
        verify(employeeDetailsRepository, times(1)).findAll();
    }

    @Test
    public void testSaveEmployeeDetails_withException() {
        // Create a sample EmployeeDetails object for testing
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setGrossSalary(BigDecimal.valueOf(10000));
        employeeDetails.setTaxPercentage(BigDecimal.valueOf(20));
        employeeDetails.setPensionPercentage(BigDecimal.valueOf(10));

        // Mock repository save method
        when(employeeDetailsRepository.save(any())).thenReturn(employeeDetails);

        // Call the service method
        EmployeeDetailsResponseDto result = payrollService.saveEmployeeDetails(employeeDetails);

        // Assertions
        verify(employeeDetailsRepository, times(1)).save(employeeDetails);
        // Add more assertions based on your requirements

        // In case of an exception, this mock will throw it
        doThrow(new RuntimeException("Test Exception")).when(employeeDetailsRepository).save(any());

        // Call the service method again, expecting an exception
        try {
            payrollService.saveEmployeeDetails(employeeDetails);
            // Fail if the exception is not thrown
            fail("Expected BusinessException, but no exception was thrown");
        } catch (BusinessException e) {
            // Add more assertions based on your requirements for the exception
            assertEquals("Exception occured from business layer", e.getMessage());
        }
    }
}

