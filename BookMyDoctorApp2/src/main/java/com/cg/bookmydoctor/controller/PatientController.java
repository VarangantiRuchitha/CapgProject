package com.cg.bookmydoctor.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.exception.ValidatePatientException;
import com.cg.bookmydoctor.serviceimpl.PatientServiceImpl;

/**
 * @author Priya Joshi
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "patient"       
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientServiceImpl patientService;

	//working
	@PostMapping("/addpatient")
	public Patient addPatient(@RequestBody Patient bean) throws PatientException, ValidatePatientException {
		return patientService.addPatient(bean);
	}

	//working
	@PutMapping("/updatepatient")
	public Patient editPatientProfile(@RequestBody Patient bean) throws PatientException {
		return patientService.editPatientProfile(bean);
	}
	
	//working
	@DeleteMapping("/removepatient")
	public Patient removePatientDetails(@RequestBody Patient bean) throws PatientException {
		return patientService.removePatientDetails(bean);
	}
	
	//working
	@GetMapping("/getpatient")
	public Patient getPatient(@RequestParam("patientId") Patient patient) throws PatientException {
		return patientService.getPatient(patient);
	}

	//working
	@GetMapping("/getallpatients")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}
	
	@GetMapping("/getallpatientbydoctor")
	public List<Patient> getPatientListByDoctor(@RequestParam("doctorname") Doctor doc) {
		return patientService.getPatientListByDoctor(doc);
	}
	
	
	@GetMapping("/getallpatienbydate")
	public List<Patient> getPatientListByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("appointmentdate")LocalDate appdate) {
		return patientService.getPatientListByDate(appdate);
	}
}