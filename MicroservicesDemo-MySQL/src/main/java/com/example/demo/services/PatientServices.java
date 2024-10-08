package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Patient;
import com.example.demo.controller.AddResponse;
import com.example.demo.repository.PatientRepo;

@Component
@Service
public class PatientServices {
	
	@Autowired
	PatientRepo newRepo;
	

	
	public List<Patient> getAllPatients()
	{
		return newRepo.findAll();
	}
	
	public Patient getPatientById(int id)
	{
		return newRepo.findById(id).get();
	}
	
	public Patient getPatientByName(String name)
	{
		List<Patient> allPatients = newRepo.findAll();
		Patient patient = null;
		for(Patient p:allPatients)
			if(p.getName().equalsIgnoreCase(name))
				patient=p;
		
		return patient;
	}
	
	public int getMaxId()
	{
		return newRepo.findAll().size()+1;
	}
	
	public Patient addPatient(Patient p)
	{
		p.setPatientID(getMaxId());
		newRepo.save(p);
		
		return(p);
	}

	public Patient updatePatient(Patient p)
	{
		newRepo.save(p);
		return p;
	}
	
	public AddResponse removePatient(int id)
	{
		AddResponse newResponse = new AddResponse();
		newRepo.deleteById(id);
		newResponse.setId(id);
		newResponse.setMsg("Patient data deleted");
		
		return newResponse;

	}
}
