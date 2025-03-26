package com.project.service;

import java.util.ArrayList;
import java.util.List;

import com.project.Dao.ProductDao;
import com.project.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.FeedbackDao;
import com.project.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Override
	public void add(Feedback feedback) {
		feedbackDao.save(feedback);
	}


	public List<Feedback> getAllFeedbacks() {
		return feedbackDao.findAll();
	}


	public Feedback saveFeedback(Feedback feedback) {
		return feedbackDao.save(feedback);
	}
	
	@Override
	public List<Feedback> getAll() {
		Iterable<Feedback> itr = feedbackDao.findAll();
		List<Feedback> lst = new ArrayList<Feedback>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}
	 
}
