package com.example.demo.beans;

public class Patient {
	
	int patientID;
	String name;
	int age;
 
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
