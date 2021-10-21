package com.asset.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.springboot.model.Employee;
import com.asset.springboot.repository.EmployeeRepository;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired 
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getEmployee() {
		return empRepo.findAll();
	}

}
