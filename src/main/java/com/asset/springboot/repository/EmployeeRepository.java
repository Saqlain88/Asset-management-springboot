package com.asset.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
