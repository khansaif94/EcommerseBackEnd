package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="ORDERS")
public class Order {		
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO) 
			private int orderid;
			@Column
			@NotNull
			private String user_name;
			@Column
			@NotNull
			private String product_name;
			@Column
			@NotNull
			private double price;
			@Column
			@NotNull
			private char status;
			@Column
			@NotNull
			private int quantity;
			@Column
			@DateTimeFormat
			private Date date_added;
			
			
			public Order() {
				
			}

			public Order(String user_name , String product_name, double price, char status, int quantity, Date data_added )
			{
				this.user_name =user_name;
				this.product_name=product_name;
				this.price=price;
				this.status=status;
				this.quantity=quantity;
				this.date_added=data_added;
				
			}
			
			
			public int getOrderid() {
				return orderid;
			}

			public void setOrderid(int orderid) {
				this.orderid = orderid;
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
			public Date getDate_added() {
				return date_added;
			}
			public void setDate_added(Date date_added) {
				this.date_added = date_added;
			}	
	}

