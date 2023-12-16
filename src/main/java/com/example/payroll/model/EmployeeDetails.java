package com.example.payroll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

// EmployeeDetails.java
@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;
    private String projectName;
    private BigDecimal grossSalary;
    private BigDecimal taxPercentage;
    private BigDecimal pensionPercentage;
    private BigDecimal additionalBenefit;
    private BigDecimal netSalary;

    public EmployeeDetails() {
    }

    public EmployeeDetails(String name,
                           String designation,
                           String projectName,
                           BigDecimal grossSalary,
                           BigDecimal taxPercentage,
                           BigDecimal pensionPercentage,
                           BigDecimal additionalBenefit) {
        this.name = name;
        this.designation = designation;
        this.projectName = projectName;
        this.grossSalary = grossSalary;
        this.taxPercentage = taxPercentage;
        this.pensionPercentage = pensionPercentage;
        this.additionalBenefit = additionalBenefit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }
}
