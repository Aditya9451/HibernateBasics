package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int tempid=1;
			Instructor tempins= session.get(Instructor.class, tempid);
			
			Course tempcourse1 =new Course("Learning Guitar");
			Course tempcourse2 =new Course("Learning Piano");
			
			tempins.add(tempcourse1);
			tempins.add(tempcourse2);
			
			session.save(tempcourse1);
			session.save(tempcourse2);
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
