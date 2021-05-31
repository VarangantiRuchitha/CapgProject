package com.cg.bookmydoctor.serviceimpl;

import java.util.List; 

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.exception.ValidateFeedBackException;
import com.cg.bookmydoctor.service.IFeedbackService;
import com.cg.bookmydoctor.util.AllConstants;

@Service
public class FeedbackServiceImpl implements IFeedbackService { 
	
	@Autowired
	private IFeedbackDao feedbackDao;
	FeedBack feedback;

	@Override
	public FeedBack addFeedback(FeedBack fdb) throws FeedBackException, ValidateFeedBackException {
		validateFeedBack(fdb);
		Optional<FeedBack> feedbackDb= feedbackDao.findById(fdb.getFeedbackId());
		if(!feedbackDb.isPresent()) {
			return feedbackDao.save(fdb);
		}  else {
			throw new FeedBackException("Feedback with id : " +fdb.getFeedbackId()+ "already exists");
		}

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) throws FeedBackException {
		Optional<FeedBack> feedbackDb = this.feedbackDao.findById(fdb.getFeedbackId());
		if(feedbackDb .isPresent()) {
			return feedbackDb .get();
		} 
		else {
			throw new FeedBackException("Feedback with ID :" + fdb.getFeedbackId()+"doesn't exist");
		}

	}

	
	
	private boolean validateFeedBack(FeedBack feedback) throws ValidateFeedBackException{
		if(feedback.getRating() < 1 && feedback.getRating() > 5) {
			throw new ValidateFeedBackException(AllConstants.INVALID_RATING);
		}
		if(!feedback.getFeedbackComment().matches(AllConstants.NAME_PATTERN)) {
			throw new ValidateFeedBackException(AllConstants.EMPTY_COMMENT);
		}
		return true;
	}

	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
