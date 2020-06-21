package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * Configuration configuration= new
		 * Configuration().configure("hibernate.cfg.xml");
		 * 
		 * 
		 * // Since version 4.x, service registry is being used ServiceRegistry
		 * serviceRegistry = new StandardServiceRegistryBuilder().
		 * applySettings(configuration.getProperties()).build();
		 * 
		 * // Create session factory instance SessionFactory factory =
		 * configuration.buildSessionFactory(serviceRegistry);
		 * 
		 * // Get current session Session session = factory.getCurrentSession();
		 */
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		
		try {
			//NEW CODE
			//session= factory.getCurrentSession();
			session.beginTransaction();
			
			// delete email for all students
			
			  System.out.println("Delete email for student");
			  session.createQuery("delete from Student where firstName='Preeti'").
			  executeUpdate();
			  session.getTransaction().commit();
			  System.out.println("Deleted");
			 
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
