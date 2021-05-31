package com.cg.bookmydoctor.service;

import java.util.List;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.exception.ValidateFeedBackException;

public interface IFeedbackService {

	public FeedBack addFeedback(FeedBack fdb) throws FeedBackException, ValidateFeedBackException;
	public FeedBack getFeedback(FeedBack fdb) throws FeedBackException;
	public List<FeedBack> getAllFeedback(Doctor doc);
	
	
}
