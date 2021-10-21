package com.asset.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.asset.springboot.model.Employee;
import com.asset.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class AssetManagementSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementSpringApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init (EmployeeRepository empRepo){
        return args -> {
        	empRepo.save(new Employee("Rahul","Team Lead Backend"));
        	empRepo.save(new Employee("Aniket","Team Lead Frontend"));
        	empRepo.save(new Employee("Shubham","Web Designer"));
        	empRepo.save(new Employee("Suraj","Jr. web developer"));
        	empRepo.save(new Employee("Kajal","Intern"));
        };
    }

}
