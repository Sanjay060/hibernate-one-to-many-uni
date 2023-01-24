package com.p4.demo;

import com.p4.demoentity.Courses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class GetCourse {
	public static void main(String[]args)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			int id=1;
			Courses c=entityManager.find(Courses.class,id);
			System.out.println(c);
			System.out.println("reviews: "+c.getReviews());
			System.out.println("found....");
			entityTransaction.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			entityManager.close();
		}
	}

}
