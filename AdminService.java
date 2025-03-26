package com.project.service;

import java.util.List;
 
import com.project.model.Admin;

public interface AdminService {
	void add(Admin admin);  
	Admin getById(int id);
	List<Admin> getAll(); 
	String login(Admin admin); 
}
