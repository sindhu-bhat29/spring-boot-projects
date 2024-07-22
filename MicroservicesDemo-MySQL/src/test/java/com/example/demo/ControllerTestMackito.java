package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.beans.Patient;
import com.example.demo.services.PatientServices;
import com.example.demo.controller.PatientController;
import com.example.demo.controller.AddResponse;

@SpringBootTest(classes= {ControllerTestMackito.class})
public class ControllerTestMackito {
	
	@Mock
	PatientServices newService;
	
	
	@InjectMocks
	PatientController newController;
	
	List<Patient> testPatients;
	
	@Test
	public void test_ListAllPatients()
	{
		List<Patient> testPatients = new ArrayList<Patient>();
		testPatients.add(new Patient(1,"Test1",28));
		testPatients.add(new Patient(2,"Test2",60));
		
		when(newService.getAllPatients()).thenReturn(testPatients);
		
		assertEquals(2,newController.listAllPatients().size());
			
	}

	@Test
	public void test_ListPatientById()
	{
		int id = 4;
		Patient p = new Patient(4,"Test",26);
		when(newService.getPatientById(id)).thenReturn(p);
		
		ResponseEntity<Patient> res = newController.ListPatientById(id);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(p,res.getBody());
		
	}
	
	@Test
	public void test_ListPatientByName()
	{
		String name = "Test";
		Patient p = new Patient(4,"Test",26);
		when(newService.getPatientByName(name)).thenReturn(p);
		
		ResponseEntity<Patient> res = newController.ListPatientByName(name);
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(p,res.getBody());
	}
	
	@Test
	public void test_AddPatient()
	{
		Patient p = new Patient(4,"Test",26);
		when(newService.addPatient(p)).thenReturn(p);
		
		assertEquals(p,newController.addPatient(p));
	}
	
	@Test
	public void test_UpdatePatient()
	{
		Patient p = new Patient(4,"Test",26);
		int id = 4;
		when(newService.getPatientById(id)).thenReturn(p);
		when(newService.updatePatient(p)).thenReturn(p);
		
		ResponseEntity res = newController.updatePatient(id, p);
		
		assertEquals(HttpStatus.OK,res.getStatusCode());
		assertEquals(p,res.getBody());
	}
	
	@Test 
	public void test_DeletePatient()
	{
		//Patient p = new Patient(3,"Test4",76);
		int id =3;
		newController.deletePatient(id);
		verify(newService,times(1)).removePatient(id);
	}
	
}
