package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.UserService;
 

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = {"/user/add"}) 
	public String userAdd(@RequestBody User user) {
		userService.add(user);
		return "success";
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping(value = {"/user/{uid}"})
	public User userGet(@PathVariable int uid) {
		return userService.getById(uid);
	}
	
	@GetMapping(value = {"/user"})
	public List<User> userList(){
		return userService.getAll();
	}

	@PostMapping(value = {"/user/login"})
	public String userLogin(@RequestBody User user) {
		return userService.login(user);
	} 
	
 
}
 
 
