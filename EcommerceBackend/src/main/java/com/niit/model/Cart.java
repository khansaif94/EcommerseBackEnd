package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CART")
public class Cart {

	@Id
	@Column(name="ID")
	private int cartid;
	
	@Column(name="USERNAME")
	private String user_name;
	
	@Column(name="PRODUCT_NAME")
	private String product_name;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="STATUS")
	private char status;
	
	@Column(name="QTY")
	private int quantity;
	
	@Column(name="DATE_ADDED")
	@DateTimeFormat
	private Date date_added;
	
	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	}

	
	
	
	

	
	
	


