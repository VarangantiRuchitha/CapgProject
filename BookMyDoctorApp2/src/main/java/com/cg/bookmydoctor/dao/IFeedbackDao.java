package com.cg.bookmydoctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bookmydoctor.dto.FeedBack;

public interface IFeedbackDao extends JpaRepository<FeedBack, Integer> {
	
}
