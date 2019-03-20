package project1;

import java.util.HashSet;
import java.util.Set;

public class EmpMain {

	public static void main(String[] args) {
		
		Set<Employee> list=new HashSet<>();
		list.add(new Employee(10, "Kiran"));
		list.add(new Employee(20, "Vikas"));
		list.add(new Employee(30, "Ajay"));
		list.add(new Employee(30, "Ajay"));
		
		for(Employee emp:list){
			System.out.println(emp.getId()+"  "+emp.getName());
		}
	}
}
