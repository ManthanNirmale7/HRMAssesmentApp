package com.jade.service;

import com.jade.RecordNotFoundException;
import com.jade.dao.EmployeeDaoImpl;
import com.jade.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public String signUp(Employee employee){
        return employeeDaoImpl.signUp(employee);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public boolean signIn(String empEmailId,String empPassword){
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getDataByName(String empName){
        return employeeDaoImpl.getDataByName(empName);
    }

    public Employee getDataByContactNumber(long empContactNumber){
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    public Employee getDataByEmailId(String empEmailId){
        return employeeDaoImpl.getDataByEmailId(empEmailId);
    }

    public List<Employee> filterDataBySalary(double empSalary){
        return  employeeDaoImpl.filterDataBySalary(empSalary);
    }

    public List<Employee> sortByName(){
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortBySalary(){
        return  employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByAge(){
        return  employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDOB(){
        return  employeeDaoImpl.sortByDOB();
    }

    public String updateData(int empId,Employee employee) throws RecordNotFoundException {
        return employeeDaoImpl.updateData(empId,employee);
    }

    public String deleteDataById(int empId) throws RecordNotFoundException {
        return employeeDaoImpl.deleteByEmpId(empId);
    }

    public String deleteAllData(){
        return employeeDaoImpl.deleteAllData();
    }

    public String saveBulkOfData(List<Employee> employeeList){
        return employeeDaoImpl.saveBulkOfData(employeeList);
    }
}
