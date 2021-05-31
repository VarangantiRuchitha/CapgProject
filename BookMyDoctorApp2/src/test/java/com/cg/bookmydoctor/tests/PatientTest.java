package com.cg.bookmydoctor.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.service.IPatientService;
import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;

public class PatientTest extends BookMyDoctorAppApplicationTests {
	@Autowired
	private IPatientService patService;
	
	@Before
	public void setUp() {
		patService = new PatientServiceImpl();
		List<Patient> patList  = new ArrayList<Patient>();
		Patient pat = new Patient(1,"Priya","8918890659","priya@gmail.com","Priya@234","A+","Female",23,"Pune");
		Patient pat1 = new Patient(2,"Soumya","7829901766","soumya@gmail.com","Soumya@234","O+","Female",28,"Hyderabad");
		
		patList.add(pat);
		patList.add(pat1);
	}
	
	@Test
	void patientServiceTest() {
		assertTrue(patService instanceof IPatientService);
	}
	
	@Test
	public void testAddPatient() throws PatientException, ValidatePatientException {
		Patient pat = new Patient(1,"Priya","8918890659","priya@gmail.com","Priya@234","A+","Female",23,"Pune");
		pat = patService.addPatient(pat);
		assertEquals(pat.getPatientId(),1);
		
		Patient pat1 = new Patient(2,"Soumya","7829901766","soumya@gmail.com","Soumya@234","O+","Female",28,"Hyderabad");
		pat1 = patService.addPatient(pat1);
		assertEquals(pat1.getPatientId(),2);
	}
	
		
	@Test
	void testEditPatientProfile() throws PatientException, ValidatePatientException {

		Patient pat = new Patient(1,"Divya","8918890659","priya@gmail.com","Priya@234","A+","Female",23,"Pune");
	    pat = patService.editPatientProfile(pat);
		assertEquals(pat.getPatientName(), "Divya"); 
	}
	
	@Test
	void testRemovePatientDetails() throws PatientException{
		Patient pat = new Patient(2,"Soumya","7829901766","soumya@gmail.com","Soumya12@","O+","Female",28,"Hyderabad");
		Patient pat1 = patService.removePatientDetails(pat);
		assertEquals(pat.getPatientId(), pat1.getPatientId());
	}
	
	@Test
	void testGetPatient() throws PatientException {
		Patient pat = new Patient(1,"Divya","8918890659","priya@gmail.com","Priya@234","A+","Female",23,"Pune");
		Patient pat1 = patService.getPatient(pat);
		assertEquals(pat.getPatientId(), 1);
	}
	
	@Test 
	void testGetAllPatient() throws PatientException {
		List<Patient> pat = patService.getAllPatient(); 
		assertNotNull(pat);
	}
	
	@After
	public void setDown() {
		patService = null;
	}
}