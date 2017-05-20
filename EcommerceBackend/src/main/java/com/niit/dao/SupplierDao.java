package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao {

	boolean saveSupplier(Supplier supplier);

	List<Supplier> getAllSupplier();

	Supplier getSupplierById(String id);

	
	 boolean deleteSupplier(Supplier supplier);

	
	 boolean updateSupplier(Supplier supplier);
	
}
