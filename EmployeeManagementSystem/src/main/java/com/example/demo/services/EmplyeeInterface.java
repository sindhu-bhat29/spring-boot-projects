package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.EmployeeDto;

public interface EmplyeeInterface {
	
	EmployeeDto createEmployee(EmployeeDto empDto);
	
	EmployeeDto getEmployeeById(int id);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(int id, EmployeeDto updatedEmp);
	
	void deleteEmployee(int id);

}
