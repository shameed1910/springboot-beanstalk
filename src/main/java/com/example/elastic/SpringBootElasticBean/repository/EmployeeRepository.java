package com.example.elastic.SpringBootElasticBean.repository;

import com.example.elastic.SpringBootElasticBean.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
