package com.cg.bookmydoctor.service;

import java.time.LocalDate;
import java.util.List;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;

public interface IPatientService {

	public Patient addPatient(Patient bean) throws PatientException, ValidatePatientException;
	public Patient editPatientProfile(Patient bean) throws PatientException;
	public Patient removePatientDetails(Patient bean) throws PatientException;
	public Patient getPatient(Patient patient) throws PatientException;
	public List<Patient> getAllPatient() throws PatientException;
	public List<Patient> getPatientListByDoctor(Doctor doctor) throws PatientException;
	public List<Patient> getPatientListByDate(LocalDate appdate) throws PatientException;
	
	
}
