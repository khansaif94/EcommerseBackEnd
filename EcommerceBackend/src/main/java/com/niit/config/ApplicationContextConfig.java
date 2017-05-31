package com.niit.config;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Category;
import com.niit.model.Supplier;

@Configuration

@ComponentScan("com.niit")

@EnableTransactionManagement

public class ApplicationContextConfig
{
	@Bean(name="datasource")
	public DataSource getH2DataSource() 
	{
		BasicDataSource dataSource = new BasicDataSource();
	//	DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		
		dataSource.setPassword("");
		
		
		return dataSource;
    }

	private Properties getHibernateProperties()
	 {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	 }
	
		@Autowired
		@Bean(name = "SessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) 
		{

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
			sessionBuilder.scanPackages("com.niit");
			return sessionBuilder.buildSessionFactory();
			
		}
		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
		{
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
		
}

