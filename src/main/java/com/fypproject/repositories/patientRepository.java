package com.fypproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fypproject.entities.Patient;

@Repository
public interface patientRepository extends JpaRepository<Patient, Integer>{
	public Patient findByEmail(String email);
	 public Patient findByCity(String city);

}
