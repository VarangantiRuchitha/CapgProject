package com.cg.bookmydoctor.service;

import java.util.List;
import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;

public interface IDoctorService {

	public Doctor addDoctor(Doctor bean) throws DoctorException, ValidateDoctorException;
	public Doctor updateDoctorProfile(Doctor bean) throws DoctorException;
	public boolean addAvailability(AvailabilityDates bean) throws DoctorException;
	public boolean updateAvailability(AvailabilityDates bean) throws DoctorException;
	public Doctor getDoctor(Doctor doc) throws DoctorException;
	public Doctor removeDoctor(Doctor doc) throws DoctorException;
	public List<Doctor> getDoctorList() throws DoctorException;
	public List<Doctor> getDoctorList(String speciality) throws DoctorException;
}
