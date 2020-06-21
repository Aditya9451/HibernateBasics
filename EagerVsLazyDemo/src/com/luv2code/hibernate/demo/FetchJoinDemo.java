package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int tempid=1;
			Query<Instructor> query= session.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "where i.id=: theInstructorId",Instructor.class);
			query.setParameter("theInstructorId", tempid);
			
			Instructor tempins= query.getSingleResult();
			System.out.println("Instructor "+tempins);
			
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
