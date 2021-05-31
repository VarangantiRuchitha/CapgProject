package com.cg.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class FeedBack {
	
	@Id
	@Column(name = "feedbackId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;
	
	@OneToOne
	@JoinColumn(name = "patientId",referencedColumnName = "patientId")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
	private Doctor doctor;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedbackComment")
	private String feedbackComment;
	
	public FeedBack() {
		}

	public FeedBack(int feedbackId, Patient patient, Doctor doctor, int rating, String feedbackComment) {
		super();
		this.feedbackId = feedbackId;
		this.patient = patient;
		this.doctor = doctor;
		this.rating = rating;
		this.feedbackComment = feedbackComment;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedbackComment() {
		return feedbackComment;
	}

	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}

	@Override
	public String toString() {
		return "FeedBack [feedbackId=" + feedbackId + ", patient=" + patient + ", doctor=" + doctor + ", rating="
				+ rating + ", feedbackComment=" + feedbackComment + "]";
	}
	
}
	
	