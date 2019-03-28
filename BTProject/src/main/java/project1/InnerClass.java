package project1;

public class InnerClass  extends Thread{

	
	@Override
	public void run() {
		
		super.run();
		System.out.println("Run() called");
	}
	
	
	public static void show(){
		Producer.produce();
		System.out.println("show");
	}

	public static void main(String[] args) {
		
		//InnerClass.Producer p=new InnerClass().new Producer();
		
		Producer p=new Producer();
		
		
		Z z=new Z(){
			@Override
			public void m1() {
				System.out.println("Anonymous called");
			}
		};
		z.m1();
		
		
		AnonymousClass obj=new AnonymousClass(){

			@Override
			public void m2() {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				p.produce();
			}
		});
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				p.consume();
			}
		});
		
		InnerClass obj1=new InnerClass();
		obj1.start();
		
		
		t.start();
		t1.start();
		
	}
	
	
	static class Producer{
		
		public static void produce(){
			show();
			System.out.println("Production");
		}
		
		public static void consume(){
			System.out.println("Consuming");
		}
	}

}
