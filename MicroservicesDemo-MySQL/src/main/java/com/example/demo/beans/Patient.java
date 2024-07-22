package com.example.demo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
	
	@Id
	@Column(name="patient_id")
	int patientID;
	
	@Column(name="patient_name")
	String name;
	
	@Column(name="patient_age")
	int age;
    
	public Patient()
	{}
	
	public Patient(int patientID, String name, int age)
	{
		this.patientID=patientID;
		this.name=name;
		this.age=age;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
