package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String name;
	private String mobile;
	private String email;

	@ManyToMany
	@JoinTable(
			name = "user_product",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	@JsonIgnore
	private List<Product> products;

	public User(int uid, String name, String mobile, String email, List<Product> products, String password) {
		this.uid = uid;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.products = products;
		this.password = password;
	}

	private String password;

    public User(List<Product> products) {
        this.products = products;
    }

	public User() {
		return ;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	

}
