package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService 
{
	
	@Autowired
	SupplierDao supplierDao;

	@Override
	public boolean saveSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.saveSupplier(supplier) ;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return supplierDao.getAllSupplier();
	}

	@Override
	public Supplier getSupplierById(String id) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierById(id);
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.deleteSupplier(supplier);
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.updateSupplier(supplier);
	}
	
	

}
