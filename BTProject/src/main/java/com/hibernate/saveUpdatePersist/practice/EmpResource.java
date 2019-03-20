package com.hibernate.saveUpdatePersist.practice;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class EmpResource {
	
	private SessionFactory sessionFactory;
	
	
	public void perform(){
		
		//Session session=sessionFactory.getCurrentSession();
		
		/*Employee emp=getTestEmployee();
		int genId=(int) session.save(emp);
		System.out.println("1. Employee save called without transaction, id="+genId);
		session.flush(); //address will not get saved without this
		System.out.println("*****");
		
		Transaction tx1 =session.beginTransaction();
		Employee empl=session.get(Employee.class, genId);
		System.out.println("Emp/Address Details"); 
		System.out.println(empl.getId()+"  "+empl.getName()+" "+empl.getAddress().getAddressLine1());
		//session.getTransaction().commit();
		tx1.commit();*/
		
		Session session = sessionFactory.openSession();
		Employee emp = getTestEmployee();
		//int id = (int) session.save(emp);
		session.persist(emp);
		int id=(int) emp.getId();
		System.out.println("1. Employee save called without transaction, id="+id);
		//session.flush(); //address will not get saved without this
		System.out.println("*****");
		
		//save example - with transaction
		Transaction tx1 = session.beginTransaction();
		/*Session session1 = sessionFactory.openSession();
		Employee emp1 = getTestEmployee();
		int id1 = (int) session1.save(emp1);
		System.out.println("2. Employee save called with transaction, id="+id1);
		System.out.println("3. Before committing save transaction");*/
		tx1.commit();
		System.out.println("4. After committing save transaction");
		System.out.println("*****");
		
		//save example - existing row in table
		/*Session session6 = sessionFactory.openSession();
		Transaction tx6 = session6.beginTransaction();
		Employee emp6 =  (Employee) session6.load(Employee.class, 20);
		
		//update some data
		System.out.println("Employee Details="+emp6);
		emp6.setName("New Name");
		emp6.getAddress().setCity("New City");
		
		int id6 = (int) session6.save(emp6);
		emp6.setName("New Name1"); // will get updated in database
		System.out.println("5. Employee save called with transaction, id="+id6);
		System.out.println("6. Before committing save transaction");
		tx6.commit();
		System.out.println("7. After committing save transaction");
		System.out.println("*****");*/
		
		// Close resources
		sessionFactory.close();
		
		
		
	}
	
	
	public static Employee getTestEmployee() {
		Employee emp = new Employee();
		Address add = new Address();
		emp.setName("Amol");
		emp.setSalary(1000);
		
		add.setAddressLine1("Hadapsar");
		add.setCity("Banglore");
		add.setZipcode("411025");
		
		emp.setAddress(add);
		add.setEmployee(emp);
		return emp;
	}
	
	
	@Autowired
	public void SomeService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory= factory.unwrap(SessionFactory.class);
	}

}
