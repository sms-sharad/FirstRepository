package project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class EmpImmutable implements Cloneable {

	final int id=100;
	 final List<String> lst=new ArrayList<>();
	
	/*public  Emp(Emp emp) {
		this.id=emp.id;
	}*/
	public EmpImmutable() {
	}

	public List<String> getLst() {
		//List<String> lst=new ArrayList<>();
		System.out.println(lst.hashCode());
		lst.add("100");
		lst.add("200");
		return Collections.unmodifiableList(lst);
	}

	public int getId() {
		return id;
	}

	/*public void setId(int id) {
		this.id = id;
	}*/
	
	@Override
	protected EmpImmutable clone() throws CloneNotSupportedException {
		return (EmpImmutable)super.clone();
		//return new Emp(this);
	}
	
	/*public void m1(Emp e){
		Emp e2=new Emp();
		e2.setId(500);
		e=e2;
	}*/
	
	/*public static void main(String[] args) throws CloneNotSupportedException {
		Emp e=new Emp();
		e.setId(100);
		Emp e1=e.clone();
		System.out.println(e.getId());//100
		System.out.println(e1.getId());//100
		e.setId(200);
		e1.setId(300);
		e.m1(e);
		Emp e2=new Emp();
		e2.setId(500);
		e=e2;
		System.out.println(e1.getId());
		System.out.println(e.getId());//200 or 500
	}*/

}
