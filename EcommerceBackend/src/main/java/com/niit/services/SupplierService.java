package com.niit.services;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierService 
{
	boolean saveSupplier(Supplier supplier);

	List<Supplier> getAllSupplier();

	Supplier getSupplierById(String id);

	
	 boolean deleteSupplier(Supplier supplier);

	
	 boolean updateSupplier(Supplier supplier);

}
