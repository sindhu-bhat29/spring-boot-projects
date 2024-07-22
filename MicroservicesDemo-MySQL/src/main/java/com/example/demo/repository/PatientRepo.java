package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
