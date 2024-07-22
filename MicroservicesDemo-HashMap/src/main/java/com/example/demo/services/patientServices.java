package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.beans.Patient;
import com.example.demo.controllers.AddResponse;
@Component

public class patientServices {
	
	static HashMap <Integer,Patient> PatientIDMap;
	
	public patientServices()
	{
		Patient patientA = new Patient(1,"AAA",68);
		Patient patientB = new Patient(2,"BBB",23);
		Patient patientC = new Patient(3,"CCC",10);
		
		PatientIDMap = new HashMap<Integer,Patient>();
		
		PatientIDMap.put(1,patientA);
		PatientIDMap.put(2,patientB);
		PatientIDMap.put(3,patientC);
		
	}
	
	public List getAllPatients()
	{
		List patients = new ArrayList(PatientIDMap.values());
		return(patients);
	}
	
	public Patient getPatientById(int Id)
	{
		return PatientIDMap.get(Id);
	}
	
	public Patient getPatientByName(String name)
	{
		Patient patient=null;
		
		for(int i:PatientIDMap.keySet())
		{
			if(PatientIDMap.get(i).getName().equals(name))
				{
				patient=PatientIDMap.get(i);
				break;
				}
		}
		return patient;
	}
	
	
	public static int getMaxIndex()
	{
		int max=0;
		for(int i:PatientIDMap.keySet())
		{
			if(i>=max)
				max = i;
		}
		return max+1;
	}

	public Patient addPatient(Patient patient)
	{
		 patient.setPatientID(getMaxIndex());
		 PatientIDMap.put(patient.getPatientID(), patient);
		 
		 return patient;
	}
	
	public AddResponse deletePatient(int id)
	{
		PatientIDMap.remove(id);
		
		AddResponse response = new AddResponse();
		
		response.setResponse("Patient data deleted");
		response.setId(id);
		
		return(response);
	}
}

	 


