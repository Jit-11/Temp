package com.project.service;

import java.util.List;

import com.project.model.Feedback;

public interface FeedbackService {
	void add(Feedback feedback);  
	List<Feedback> getAll();

	List<Feedback> getAllFeedbacks();

	Feedback saveFeedback(Feedback feedback);
}
