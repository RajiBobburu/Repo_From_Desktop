package com.spring.dto;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mobilenumber;
	private double totalcost;
	
@ManyToOne
private User user;

@OneToMany
@Cascade (CascadeType.ALL)
private List<Item> items;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(long mobilenumber) {
	this.mobilenumber = mobilenumber;
}

public double getTotalcost() {
	return totalcost;
}

public void setTotalcost(double totalcost) {
	this.totalcost = totalcost;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}


}
