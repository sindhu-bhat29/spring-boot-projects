package com.example.demo.mapper;

import com.example.demo.bean.Employee;
import com.example.demo.dto.EmployeeDto;

public class EmplyeeMapper {
	
	
	
	public static EmployeeDto maptoDto(Employee emp)
	{
		return new EmployeeDto(emp.getEmployee_id(),emp.getName(),emp.getAge(),emp.getEmailid());
	}
	
	public static Employee mapToEmployee(EmployeeDto empDto)
	{
		return new Employee(empDto.getId(),empDto.getName(),empDto.getAge(),empDto.getEmailid());
	}
	

}
