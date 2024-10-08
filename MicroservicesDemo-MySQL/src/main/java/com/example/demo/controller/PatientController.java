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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Patient;
import com.example.demo.services.PatientServices;

@RestController
public class PatientController {
	
	@Autowired
	PatientServices newService;
	
	@GetMapping("/allPatients")
	public List<Patient> listAllPatients()
	{
		return newService.getAllPatients();
	}
	
	@GetMapping("/allPatients/{id}")
	public ResponseEntity<Patient> ListPatientById(@PathVariable(value="id") int id)
	{
		try {
			Patient p=newService.getPatientById(id);
		
		    return new ResponseEntity<Patient>(p,HttpStatus.OK);
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/allPatients/name")
	public ResponseEntity<Patient> ListPatientByName(@RequestParam(value="name") String name)
	{
		try
		{
			Patient p = newService.getPatientByName(name);
			return new ResponseEntity<Patient>(p,HttpStatus.OK);
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient p)
	{
		newService.addPatient(p);
		return(p);
	}
	
	@PutMapping("/updatePatient/{id}")
	
	public ResponseEntity<Patient> updatePatient(@PathVariable(value="id") int id,@RequestBody Patient p)
	{
		try 
		{
			Patient existPatient = newService.getPatientById(id);
			existPatient.setName(p.getName());
			existPatient.setAge(p.getAge());
			
			
			return new ResponseEntity<Patient>(newService.updatePatient(existPatient),HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public AddResponse deletePatient(@PathVariable(value="id") int id)
	{
		return newService.removePatient(id);
	}
	
	

}
