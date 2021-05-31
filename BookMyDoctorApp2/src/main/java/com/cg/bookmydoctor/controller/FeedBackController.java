package com.cg.bookmydoctor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.exception.ValidateFeedBackException;
import com.cg.bookmydoctor.serviceimpl.FeedbackServiceImpl;

/**
 * @author Shivani
 *          REST Controller with different HTTP methods 
 *          as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "feedback"       
 */
   
@RestController
@RequestMapping("/feedback")
public class FeedBackController {
	
	@Autowired
	FeedbackServiceImpl feedbackService;


	@GetMapping("/getallfeedback")
	public List<FeedBack> getAllFeedBack(Doctor doctor) {
		return feedbackService.getAllFeedback(doctor);
	}

	//working
	@PostMapping("/addfeedback")
	public FeedBack addFeedback(@RequestBody FeedBack feedback) throws FeedBackException, ValidateFeedBackException {
		return feedbackService.addFeedback(feedback);
	}

	//working
	@GetMapping("/getfeedback")
	public FeedBack getFeedback(@RequestParam("feedbackid") FeedBack fdb) throws FeedBackException {
		return feedbackService.getFeedback(fdb);
	}
	
}
