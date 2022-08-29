package com.jade.dao;

import com.jade.RecordNotFoundException;
import com.jade.model.Employee;
import com.jade.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public String signUp(Employee employee){
        employeeRepositoryImpl.save(employee);
        return "Signed up successfully";
    }

    public List<Employee> getAllData(){
        return employeeRepositoryImpl.findAll();
    }

    public boolean signIn(String empEmailId,String empPassword){
        boolean flag=false;

        for(Employee employee: getAllData()){
            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){
                flag=true;
            }
        }
        return flag;
    }

    public Optional<Employee> getDataById(int empId){
        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getDataByName(String empName){
        return employeeRepositoryImpl.findByEmpName(empName);
    }

    public Employee getDataByContactNumber(long empContactNumber){
        return employeeRepositoryImpl.findByEmpContactNumber(empContactNumber);
    }

    public Employee getDataByEmailId(String empEmailId){
       int length= empEmailId.length();
        return employeeRepositoryImpl.findByEmpEmailId(empEmailId);
    }

    public List<Employee> filterDataBySalary(double empSalary){
        return getAllData().stream().filter(emp->emp.getEmpSalary()>=empSalary).sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortByName(){
        return getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
    }

    public List<Employee> sortBySalary(){
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortByAge(){
        return getAllData().stream().sorted(Comparator.comparingInt(Employee::getEmpAge)).collect(Collectors.toList());
    }

    public List<Employee> sortByDOB(){
        return getAllData().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).collect(Collectors.toList());
    }

    public String updateData(int empId,Employee employee) throws RecordNotFoundException {

        Employee employee1= getDataById(empId).orElseThrow(()->new RecordNotFoundException("****** Employee with id " + empId + " Not Found ******"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());
        employeeRepositoryImpl.save(employee1);
        return "Data updated Successfully!";
    }

    public String deleteByEmpId(int empId) throws RecordNotFoundException {
        Employee employee=getDataById(empId).orElseThrow(()-> new RecordNotFoundException("****** No record found with id:"+ empId + " ******"));
        employeeRepositoryImpl.deleteById(empId);
        return "Data deleted successfully!";
    }

    public String deleteAllData(){
        employeeRepositoryImpl.deleteAll();
        return "Data deleted successfully!";
    }

    public String saveBulkOfData(List<Employee> employeeList){

       List<Employee> employeeList1= new ArrayList<>();
       for(Employee employee:employeeList){
           employeeList1.add(employee);
       }
       employeeRepositoryImpl.saveAll(employeeList1);
       return "Data inserted successfully! ";
    }

}
