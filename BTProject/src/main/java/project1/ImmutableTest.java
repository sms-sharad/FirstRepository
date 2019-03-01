package project1;

import java.util.List;

public class ImmutableTest {

	public static void main(String[] args) {
		
		EmpImmutable e=new EmpImmutable();
		List<String> lst= e.getLst();
		System.out.println(lst);
		System.out.println(lst.hashCode());
		/*lst.add("400");
		lst.add("200");
		lst.add("300");*/
		
		List<String> lst1= e.getLst();
		//lst1.add("500");
		System.out.println(lst1.hashCode());
		
		//System.out.println(lst);
		
	}

}
