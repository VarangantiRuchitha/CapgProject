package com.cg.bookmydoctor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;

/**
 * @author SaiPriya 
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "doctor"       
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl doctorService;

	//working
	@PostMapping("/adddoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) throws DoctorException, ValidateDoctorException {
		return doctorService.addDoctor(doctor);
	}

	//working
	@GetMapping("/getalldoctors")
	public List<Doctor> getDoctorList() {
		return doctorService.getDoctorList();
	}

	//working
	@DeleteMapping("/removedoctor")
	public Doctor removeDoctor(@RequestBody Doctor doctor) throws DoctorException {
		return doctorService.removeDoctor(doctor);
	}

	//working
	@PutMapping("/updatedoctor")
	public Doctor updateDoctorProfile(@RequestBody Doctor doctor) throws DoctorException {
		return doctorService.updateDoctorProfile(doctor);
	}
	
	//working
	@GetMapping("/getdoctor/{doctorId}")
	public Doctor getDoctor(@PathVariable("doctorId") Doctor doc) throws DoctorException {
		return doctorService.getDoctor(doc);
	}
	
	//working
	@GetMapping("/getdoctors/{speciality}")
	public List<Doctor> getDoctorList(@PathVariable("speciality") String speciality) throws DoctorException {
		return doctorService.getDoctorList(speciality);
	}
	
	//working
	@PostMapping("/addavailability")
	public boolean addAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.addAvailability(bean);
	}
	
    //working
	@PutMapping("/updateavailability")
	public boolean updateAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.updateAvailability(bean);
	}
	
}