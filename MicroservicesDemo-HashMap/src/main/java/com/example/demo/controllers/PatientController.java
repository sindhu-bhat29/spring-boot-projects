package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Patient;
import com.example.demo.services.patientServices;

@RestController
public class PatientController {
	
	@Autowired
	patientServices patient;
	
	@GetMapping("/allPatients")
	public List getAllPatients()
	{
	    return patient.getAllPatients();
	}
	
	@GetMapping("/allPatients/{id}")
	public Patient getById(@PathVariable(value="id") int patientID)
	{
		return patient.getPatientById(patientID);
	}
	
	@GetMapping("/allPatients/patientName")
	public Patient getByName(@RequestParam(value="name") String patientName)
	{
		return patient.getPatientByName(patientName);
	}
	
	@PostMapping("/allPatients")
	public Patient addPatient(@RequestBody Patient newPatient)
	{
		return patient.addPatient(newPatient);
	}
	
	@DeleteMapping("/allPatients/{id}")
	public AddResponse deletePatient(@PathVariable(value="id") int id)
	{
		return patient.deletePatient(id);
	}
	
	
	
	

}
