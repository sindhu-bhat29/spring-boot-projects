package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
