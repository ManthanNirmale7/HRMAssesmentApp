package com.jade.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    private String empName;

    @Column(unique = true)
    private long empContactNumber;

    private int empAge;

    private double empSalary;

    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "Asia/Kolkata")
    private Date empDOB;

    @Column(unique = true)
    private String empEmailId;

    private String empPassword;
}
