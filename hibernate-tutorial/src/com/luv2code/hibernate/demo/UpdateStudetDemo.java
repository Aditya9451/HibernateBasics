package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			String studentId="1";
			session.beginTransaction();
			// retrieve student based on Student id:primary id
			Student mystudent= session.get(Student.class, studentId);
			System.out.println("Updating student");
			mystudent.setFirstName("AdityaJi");
			session.getTransaction().commit();
			System.out.println("Done");
			
			//NEW CODE
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for All students");
			session.createQuery("update Student set email='same@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Updated");
			
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
