package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.UserDao;
import com.project.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;


	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User getUserById(int id) {
		return userDao.findById(id).orElse(null);
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}
	@Override
	public void add(User user) {
		userDao.save(user); 
	}
  
	@Override
	public List<User> getAll() {
		Iterable<User> itr = userDao.findAll();
		List<User> lst = new ArrayList<User>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}

	@Override
	public User getById(int id) {
		Optional<User> opt = userDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public String login(User user) { 
		List<User> lst = new ArrayList<User>();
		lst =userDao.findAllActiveUsersNative(user.getEmail(),user.getPassword());
		if (lst.isEmpty() || lst==null) {
			return "Invalid user";
		}
		else {
			return "Login successful";
		}
		
	}

//	@Override
//	public User getByEmailAndPassword(String email, String password) {
//		return userDao.findByEmailAndPhone(email, password);
//	}
//	
	
  
}
