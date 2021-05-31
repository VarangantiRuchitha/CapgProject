package com.cg.bookmydoctor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidateAppointmentException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.serviceimpl.AppointmentServiceImpl;
import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;
import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;

public class AppointmentTest extends BookMyDoctorAppApplicationTests {
	
	
	@Autowired
	AppointmentServiceImpl asi;
	@Autowired
	DoctorServiceImpl docService;
	PatientServiceImpl patService;
	
	@Test
	void testAppointmentServiceImpl() throws ValidateAppointmentException {
		assertTrue(asi instanceof AppointmentServiceImpl);
	}
	
	@Test
	void testAddAppointment() throws AppointmentException, DoctorException, ValidateDoctorException, PatientException, ValidatePatientException {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi@1234", 800);
		docService.addDoctor(doctor);
		Patient patient = new Patient(2, "V Raghav", "9988742355","raghav@gmail.com", "Raghav@12", "O-","male",32, "Kphb Colony, Hyderabad");
		patService.addPatient(patient);
		Appointment app = new Appointment(1, doctor, patient, LocalDate.of(2021,01,13), "Approved", "Good");
		app = asi.addAppointment(app);
		assertNotNull(app);
	
	}

}