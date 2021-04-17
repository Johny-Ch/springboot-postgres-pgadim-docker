package com.learning.docker.controller;

import com.learning.docker.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.learning.docker.model.Employee;

@RestController
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getallemployees")
    public List<Employee> getAllEmployess(){
        logger.info("Getting all employees");
        return employeeRepository.findAll();
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        logger.info("Creating employee : {}", employee.toString());
        return employeeRepository.save(employee);
    }
}
