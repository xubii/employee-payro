package com.example.payroll.dto;

import com.example.payroll.model.EmployeeDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class EmployeeDetailsRequestDto {

    @NotBlank(message = "Invalid Name")
    private String name;
    @NotBlank(message = "Invalid Designation")
    private String designation;
    @NotBlank(message = "Invalid Project Name")
    private String projectName;
    @NotNull(message = "Invalid Gross Salary")
    private BigDecimal grossSalary;
    @NotNull(message = "Invalid Tax Percentage")
    private BigDecimal taxPercentage;
    @NotNull(message = "Invalid  Pension Percentage")
    private BigDecimal pensionPercentage;
    @NotNull(message = "Invalid Additional Benefit")
    private BigDecimal additionalBenefit;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public BigDecimal getPensionPercentage() {
        return pensionPercentage;
    }

    public void setPensionPercentage(BigDecimal pensionPercentage) {
        this.pensionPercentage = pensionPercentage;
    }

    public BigDecimal getAdditionalBenefit() {
        return additionalBenefit;
    }

    public void setAdditionalBenefit(BigDecimal additionalBenefit) {
        this.additionalBenefit = additionalBenefit;
    }

    public EmployeeDetails mapTo() {
        return new EmployeeDetails(
                this.name,
                this.designation,
                this.projectName,
                this.grossSalary,
                this.taxPercentage,
                this.pensionPercentage,
                this.additionalBenefit
        );
    }
}
