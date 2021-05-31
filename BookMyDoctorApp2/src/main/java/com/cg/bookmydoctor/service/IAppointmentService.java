package com.cg.bookmydoctor.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.AppointmentException;
import com.cg.bookmydoctor.exception.ValidateAppointmentException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.exception.ValidatePatientException;

public interface IAppointmentService {
	
	public List<Appointment> getAllAppointments() throws AppointmentException;
	public Appointment getAppointment(int appointmentId) throws AppointmentException;
	public boolean deleteAppointment(int appointmentId) throws AppointmentException;
	public boolean updateAppointment(Appointment bean) throws AppointmentException;
	public List<Appointment> getAppointments(Doctor doc) throws AppointmentException;
	public List<Appointment> getAppointments(LocalDate date) throws AppointmentException;
	public Appointment addAppointment(Appointment app) throws AppointmentException, ValidateAppointmentException, ValidateDoctorException, ValidatePatientException;
	

}
