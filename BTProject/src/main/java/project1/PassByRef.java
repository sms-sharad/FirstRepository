package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassByRef {
	
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}

	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		System.out.println("a="+a+" b:"+b);
		swap(a, b);
		System.out.println("a="+a+" b:"+b);
		
		
		int[] arr = null;
		System.out.println(Arrays.toString(arr));
		modify(arr);
		System.out.println(Arrays.toString(arr));
		
		/*String s1="Virtusa";
		System.out.println(s1);
		modifyStr(s1,"Accenture");
		System.out.println(s1);
		
		
		PassByRef obj=new PassByRef();
		obj.setId(100);
		System.out.println(obj.getId());
		modifyObj(obj);
		System.out.println(obj.getId());
		
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		modifyList(list);
		System.out.println(list);*/
		
	}

	private static void modifyList(List<Integer> list) {
		list.add(3);
		list.add(4);
	}

	private static void modifyObj(PassByRef obj) {
		obj.setId(200);
	}

	private static void modifyStr(String s1,String s2) {
		s1=s2;
		
	}

	private static void modify(int[] arr) {
		arr=new int[]{3,4,5};
		//arr[0]=3;
	}

}
