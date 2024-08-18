package com.spring.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String email;
	private String password;
	
	@OneToMany
	@Cascade (CascadeType.ALL)
	private List<FoodOrder> foodorders;;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<FoodOrder> getFoodorders() {
		return foodorders;
	}
	public void setFoodorders(List<FoodOrder> foodorders) {
		this.foodorders = foodorders;
	}
	
	

}
