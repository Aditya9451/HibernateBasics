package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// querying a student
			session = factory.getCurrentSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Student> studentLists = session.createQuery("from Student").getResultList();
			displayStudents(studentLists);

			// commit transaction
			session.getTransaction().commit();

			// query a student whose lastname is kumari
			session = factory.getCurrentSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Student> studentListsCondition = session.createQuery("from Student s where s.lastName='Kumari'")
					.getResultList();
			displayStudents(studentListsCondition);
			
			// query a student whose firstname is Aditya and lastname is Raj
			session = factory.getCurrentSession();
			//session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Student> studentListsConditiontwo = session.createQuery("from Student s where" + " s.lastName='Raj' OR s.firstName='Aditya'")
					.getResultList();
			System.out.println("condition check");
			displayStudents(studentListsConditiontwo);
			
			
			// query student whose email LIKE '%gmail.com'
			@SuppressWarnings("unchecked")
			List<Student> studentListsLikeCondition = session.createQuery("from Student s where" + " s.email LIKE '%gmail.com'")
					.getResultList();
			System.out.println("condition like");
			displayStudents(studentListsLikeCondition);
			System.out.println("end");
			
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentListsCondition) {
		for (Student studentdata : studentListsCondition) {
			System.out.println(studentdata);
		}
	}

}
