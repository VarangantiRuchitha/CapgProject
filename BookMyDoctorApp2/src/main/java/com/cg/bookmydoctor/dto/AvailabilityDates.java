package com.cg.bookmydoctor.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "AvailabilityDates")
public class AvailabilityDates implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "availabiltyId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int availabilityId;
	
	@OneToOne
	@JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
	private Doctor doctor;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name="fromDate")
	private LocalDate fromDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name="endDate")
	private LocalDate endDate;

	public AvailabilityDates() {
		
	}

	public AvailabilityDates(int availabilityId, Doctor doctor, LocalDate fromDate, LocalDate endDate) {
		super();
		this.availabilityId = availabilityId;
		this.doctor = doctor;
		this.fromDate = fromDate;
		this.endDate = endDate;
	}

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
	
	