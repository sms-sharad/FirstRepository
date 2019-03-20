package com.jpaHibernate.practice;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
//@Repository
@Component
public class StudentResource {

	//@Autowired
	private SessionFactory sessionFactory;

	public void m1() throws Exception{
		
		//First Session using save()
		Session session = sessionFactory.openSession();
		Student stud=new Student("Vikas", "KP94039");
		int stdid1=(int) session.save(stud);
		System.out.println("Save method perfor ID1:: "+stdid1);
		session.beginTransaction();
		session.getTransaction().commit();
		
		//Second Session using update method
		Session session_1 = sessionFactory.openSession();
		session_1.beginTransaction();
		stud.setName("Dnyanu");
		//session1.refresh(stud);
		session_1.saveOrUpdate(stud);
		session_1.getTransaction().commit();
		Student std1=session_1.load(Student.class, stdid1);
		System.out.println("LOAD method");
		System.out.println(std1.getName()+" "+std1.getPassportNumber());
		
		//Third Session using saveOrUpdate
		Session session_2=sessionFactory.openSession();
		session_2.beginTransaction();
		Student std=new Student("Kiran", "KP94036");
		session_2.persist(std);
		session_2.getTransaction().commit();
		
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
		
		
		//using merge() method
		
		/*Session session_1 = sessionFactory.openSession();
		session_1.beginTransaction();
		stud.setName("Dnyanu");
		//session1.refresh(stud);
		Student std=(Student) session_1.merge(stud);
		session_1.getTransaction().commit();
		
		Student std1=session_1.load(Student.class, stdId);
		System.out.println("LOAD method");
		System.out.println(std1.getName()+" "+std1.getPassportNumber());*/
		
		//using update()
		
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
