package com.project.service;

import java.util.List;

import com.project.model.User;

public interface UserService {
	void add(User user);
	User getById(int id);
	List<User> getAll();
	String login(User user);

	List<User> getAllUsers();

	User saveUser(User user);

	User getUserById(int id);
}
