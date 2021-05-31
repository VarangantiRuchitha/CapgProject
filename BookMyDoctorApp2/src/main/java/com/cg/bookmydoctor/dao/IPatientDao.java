package com.cg.bookmydoctor.dao;

import com.cg.bookmydoctor.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientDao  extends JpaRepository<Patient, Integer> {
	
	

}
