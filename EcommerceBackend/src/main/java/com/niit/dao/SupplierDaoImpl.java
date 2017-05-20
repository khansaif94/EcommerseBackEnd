package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao 
{

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveSupplier(Supplier supplier) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(supplier);
				session.flush();
				session.close();
		
		return true;
		} 
		catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	public List<Supplier> getAllSupplier() {
		Session  session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> supplierList=query.list();
		session.close();
		return supplierList;
	}

	public Supplier getSupplierById(String id) {
		Session session=sessionFactory.openSession();
		Supplier sup=(Supplier)session.get(Supplier.class, id);
		session.flush();
        session.close();
        return sup;
	}


		public Supplier getSupplierByName(String name) {
			Session session=sessionFactory.openSession();
			Supplier sup=(Supplier)session.createQuery("from Supplier where name = '"+name + "'").list().get(0);
			session.flush();
	        session.close();
	        return sup;
			 
				

	}

		@Override
		public boolean deleteSupplier(Supplier supplier) {
			try {
				Session session =sessionFactory.openSession();
				session.delete(supplier);
				session.flush();
				session.close();
				return true;
				
			} 
			catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
		}

		@Override
		public boolean updateSupplier(Supplier supplier) {
			try {
				Session session =sessionFactory.openSession();
				session.update(supplier);
				session.flush();
				session.close();
				return true;
			}
		catch (Exception e)
			{
				e.printStackTrace();
				return false;
				
			}	
		}

	
}
