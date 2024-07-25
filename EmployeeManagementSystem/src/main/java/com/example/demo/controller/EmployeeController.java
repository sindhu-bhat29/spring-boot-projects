package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.services.impl.EmployeeService;

@RestController
@RequestMapping("/allEmployees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto empDto)
	{
		EmployeeDto empDto1 = empService.createEmployee(empDto);
		return new ResponseEntity<EmployeeDto>(empDto1,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value="id") int id)
	{
		EmployeeDto empDto = empService.getEmployeeById(id);
		return new ResponseEntity<EmployeeDto>(empDto,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees()
	{
		List<EmployeeDto> listEmpDto = empService.getAllEmployee();
		return new ResponseEntity<List<EmployeeDto>>(listEmpDto,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmpyee(@PathVariable (value="id") int id,@RequestBody EmployeeDto emp)
	{
		return new ResponseEntity<EmployeeDto>(empService.updateEmployee(id, emp),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable (value="id") int id)
	{
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}
	

}
