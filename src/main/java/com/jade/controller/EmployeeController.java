package com.jade.controller;

import com.jade.RecordNotFoundException;
import com.jade.model.Employee;
import com.jade.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }

     @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
     }

     @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
     }

     @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return  ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
     }

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable long empContactNumber){
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }

    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));
    }

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary(){
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }

    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge(){
        return ResponseEntity.ok(employeeServiceImpl.sortByAge());
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB(){
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId,@RequestBody Employee employee) throws RecordNotFoundException {
        return ResponseEntity.ok(employeeServiceImpl.updateData(empId,employee));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataByEmpId(@PathVariable int empId) throws RecordNotFoundException {
        return ResponseEntity.ok(employeeServiceImpl.deleteDataById(empId));
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteDataByEmpId() {
        return ResponseEntity.ok(employeeServiceImpl.deleteAllData());
    }

    @PostMapping("/savebulkofdata")
    public ResponseEntity<String> saveBulkOfData(@RequestBody List<Employee> employeeList){
        return ResponseEntity.ok(employeeServiceImpl.saveBulkOfData(employeeList));
    }


}
