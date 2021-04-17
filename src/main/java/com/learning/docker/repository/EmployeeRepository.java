package com.learning.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.docker.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
