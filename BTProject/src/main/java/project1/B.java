package project1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class B extends A{
	
	int a=200;
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		A a=new A();
		
		Class cls=a.getClass();
		
		Method[] method= cls.getDeclaredMethods();
		for(Method m:method){
			System.out.println(m.getName());
		}
		
		Method m=cls.getDeclaredMethod("m2");
		m.setAccessible(true);
		m.invoke(a);
		
		
	}

}
