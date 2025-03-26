package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.model.Feedback;
import com.project.service.FeedbackService;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping(value = {"/add"})
	public String productAdd(@RequestBody Feedback feedback) {
		feedbackService.add(feedback);
		return "success";
	}

	@GetMapping(value = {"/get"})
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedbacks();
	}

	@PostMapping
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}
}
