package com.au.jdbc.jdbc.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id 
	private int lid;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String brand;
	private String price;
}

