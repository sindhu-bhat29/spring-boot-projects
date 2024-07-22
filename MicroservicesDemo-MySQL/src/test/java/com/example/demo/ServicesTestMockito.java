package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Patient;
import com.example.demo.repository.PatientRepo;
import com.example.demo.services.PatientServices;


@SpringBootTest(classes= {ServicesTestMockito.class})
public class ServicesTestMockito {
	
	@Mock
	PatientRepo newRepo;
	
	@InjectMocks
	PatientServices newService;
	
	public List<Patient> testPatients;
	
	@Test
	@Order(1)
	public void test_GetAllPatients()
	{
		List<Patient> testPatients = new ArrayList<Patient>();
		testPatients.add(new Patient(1,"Test1",28));
		testPatients.add(new Patient(2,"Test2",60));
		
		when(newRepo.findAll()).thenReturn(testPatients);
		assertEquals(2,newService.getAllPatients().size());
	}
	
	@Test 
	@Order(2)
	public void test_GetPatientById()
	{
		/*
		 * List<Patient> testPatients = new ArrayList<Patient>(); testPatients.add(new
		 * Patient(1,"Test1",28)); testPatients.add(new Patient(2,"Test2",60));
		 */
		Optional<Patient> TestPatient = Optional.ofNullable(new Patient(1,"Test",29));
		
		Integer id = 1;
		when(newRepo.findById(id)).thenReturn(TestPatient);
		assertEquals(1,newService.getPatientById(1).getPatientID());
	}
	
	@Test
	public void test_getPatientByName()
	{
		List<Patient> testPatients = new ArrayList<Patient>();
		testPatients.add(new Patient(1,"Test1",28));
		testPatients.add(new Patient(2,"Test2",60));
		
		when(newRepo.findAll()).thenReturn(testPatients);
		
		assertEquals("Test1",newService.getPatientByName("Test1").getName());
	}
	
	@Test
	public void test_AddPatient()
	{
		Patient p = new Patient(3,"Test3",76);
		when(newRepo.save(p)).thenReturn(p);
		assertEquals(p,newService.addPatient(p));
	}
	
	@Test
	public void test_UpdatePatient()
	{
		Patient p = new Patient(3,"Test4",76);
		when(newRepo.save(p)).thenReturn(p);
		assertEquals(p,newService.updatePatient(p));
	}
	
	@Test 
	public void test_RemovePatient()
	{
		//Patient p = new Patient(3,"Test4",76);
		int id =3;
		newService.removePatient(id);
		verify(newRepo,times(1)).deleteById(id);
	}
	
	

}
