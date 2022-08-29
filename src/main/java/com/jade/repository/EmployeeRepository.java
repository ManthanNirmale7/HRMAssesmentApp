package com.jade.repository;

import com.jade.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



     public List<Employee> findByEmpName(String empName);

     public Employee findByEmpContactNumber(long empContactNumber);

     public Employee findByEmpEmailId(String empEmailId);


}
