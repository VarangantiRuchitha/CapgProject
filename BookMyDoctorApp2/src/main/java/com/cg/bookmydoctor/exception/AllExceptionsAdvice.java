package com.cg.bookmydoctor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.bookmydoctor.dto.ErrorMessage;

@RestControllerAdvice
public class AllExceptionsAdvice {
	
	@ExceptionHandler(AdminException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleAdminException(AdminException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateAdminException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleAdminException(ValidateAdminException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(AppointmentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleAppointmentException(AppointmentException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateAppointmentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleAppointmentException(ValidateAppointmentException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(AvailabilityException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleAvailabilityException(AvailabilityException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateAvailabilityException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleAvailabilityException(ValidateAvailabilityException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(DoctorException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleDoctorException(DoctorException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateDoctorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleDoctorException(ValidateDoctorException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(PatientException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handlePatientException(PatientException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidatePatientException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handlePatientException(ValidatePatientException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(FeedBackException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleFeedBackException(FeedBackException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateFeedBackException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleFeedBackException(ValidateFeedBackException exception) {
		return new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	

}
