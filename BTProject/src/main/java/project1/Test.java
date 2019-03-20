package project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static List<Integer> getData(List<Integer> list){
		list.add(50);
		System.out.println("+++ "+list);
		return list;
	}
	
	volatile int[] arr1=new int[7];
	
	public static void main(String[] args) {
		
		List<Integer> lst=new ArrayList<>();
		lst.add(10);
		lst.add(20);
		lst.add(30);
		List<Integer> list=Collections.unmodifiableList(lst);
		System.out.println(lst.equals(list));
		//System.out.println(list.hashCode()==lst.hashCode());
		//10 20 30 50
		
		lst.add(40);
		
		System.out.println(getData(list));
		
		//10 20 30
		System.out.println(list);
		
		
		//=new int[]{1,2,3};
		
		
	}

}
