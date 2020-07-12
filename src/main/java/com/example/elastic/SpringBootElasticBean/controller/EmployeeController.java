package com.example.elastic.SpringBootElasticBean.controller;


import com.example.elastic.SpringBootElasticBean.Model.Employee;
import com.example.elastic.SpringBootElasticBean.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        return employeeRepository.save(employee);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){

        return  ResponseEntity.ok(employeeRepository.findAll());
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmplooyeeId(@PathVariable(value = "id")
                                                    Integer id){
       Employee employee= employeeRepository.findById(id).orElseThrow(
               ()->new ResourceNotFoundException("EMployee not found"+id));
               return ResponseEntity.ok().body(employee);

    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id")
                                                       Integer id){
        Employee employee= employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("EMployee not found"+id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
