package com.jpaHibernate.practice;

import javax.persistence.EntityManagerFactory;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Transactional
//@Repository
@Component
public class StudentResource {

	//@Autowired
	private SessionFactory sessionFactory;

	public void m1() throws Exception{
		System.out.println("In m1");
		Session session = sessionFactory.getCurrentSession();
		
		
		Student stud=new Student("Vikas", "ABC");
		session.save(stud);
		int stdId=stud.getId();
		System.out.println("ID:: "+stdId);
		session.beginTransaction();
		session.getTransaction().commit();
		
		/*Session session1 = sessionFactory.getCurrentSession();
		session1.beginTransaction();
		stud.setName("Dnyanu");
		//session1.refresh(stud);
		session1.merge(stud);
		
		Student std=session1.load(Student.class, stdId);
		System.out.println("LOAD method");
		System.out.println(std.getName()+" "+std.getPassportNumber());
		session1.getTransaction().commit();*/
		
		
		
		/*Session session_2=sessionFactory.getCurrentSession();
		session_2.beginTransaction();
		Student std1=session_2.get(Student.class, stdId);
		System.out.println("GET method");
		System.out.println(std1.getName()+" "+std1.getPassportNumber());*/
		
		
		//Merge method
		
		/*Session session_1 = sessionFactory.getCurrentSession();
		session_1.beginTransaction();
		stud.setName("Dnyanu");
		//session1.refresh(stud);
		Student std=(Student) session_1.merge(stud);
		session_1.getTransaction().commit();
		
		Student std1=session_1.load(Student.class, stdId);
		System.out.println("LOAD method");
		System.out.println(std1.getName()+" "+std1.getPassportNumber());*/
		
		
		
		
		//getSessionFactory().close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void SomeService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory= factory.unwrap(SessionFactory.class);
	}

}
