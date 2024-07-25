package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmplyeeMapper;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.services.EmplyeeInterface;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Service
public class EmployeeService implements EmplyeeInterface{
	
	
	private EmployeeRepo empRepo;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto)
	{
		
		Employee newEmployee = EmplyeeMapper.mapToEmployee(empDto);
		Employee addedEmployee = empRepo.save(newEmployee);
		return EmplyeeMapper.maptoDto(addedEmployee);
		
		
	}

	
	 @Override 
	 public EmployeeDto getEmployeeById(int id) 
	 { 
		 Employee newEmployee = empRepo.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Employee Not found for requested ID:" + id));
		 
		 return EmplyeeMapper.maptoDto(newEmployee);
	 }


	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		List<Employee> allEmployees = empRepo.findAll();
		
		return allEmployees.stream().map(employee -> EmplyeeMapper.maptoDto(employee))
				.collect(Collectors.toList());
		
		
	}


	@Override
	public EmployeeDto updateEmployee(int id, EmployeeDto updatedEmp) {
		
		Employee oldEmp = empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
		
		oldEmp.setName(updatedEmp.getName());
		oldEmp.setAge(updatedEmp.getAge());
		oldEmp.setEmailid(updatedEmp.getEmailid());
		
		oldEmp = empRepo.save(oldEmp);
		
		EmployeeDto newEmp = EmplyeeMapper.maptoDto(oldEmp);
		return newEmp;
	}


	@Override
	public void deleteEmployee(int id) {
		
		Employee emp = empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee ID Not found"));
		
		empRepo.deleteById(id);
		
	}
	 

	
	
}
