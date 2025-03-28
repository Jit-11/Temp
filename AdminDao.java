package com.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Admin;

 
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	List<Admin> findByName(@Param(value = "name") String name);
	
	@Query(value = "SELECT * FROM admin a WHERE a.email = :email and a.password=:password", nativeQuery = true)
	List<Admin> findAllActiveAdminsNative(@Param(value = "email") String email, @Param(value = "password") String password);

}