package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Table
@Entity
public class Supplier {	
	@Id
	@Column(name="ID")
	private String supplierid;
	
	@Column(name="NAME")
	private String suppliername;
	
	@Column(name="ADDRESS")
	private String supplieradd;
	
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplieradd() {
		return supplieradd;
	}
	public void setSupplieradd(String supplieradd) {
		this.supplieradd = supplieradd;
	}	

}
