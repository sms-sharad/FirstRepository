package com.program.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		Integer[] arr=new Integer[]{1,2,1,4,5,6,4,3,8,7};
		Set<Integer> set=new LinkedHashSet(Arrays.asList(arr));
		
		set.stream().sorted().forEach(K->System.out.print(K+""));
		
		PC pc=new PC();
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//t1.start();
		//t2.start();
		
		t1.join();
		t2.join();

	}
	
	
	public static class PC{
		
		List<Integer> list=new ArrayList<>();
		int capacity=5;
		public void produce() throws InterruptedException{
			int value=0;
			while(true){
				synchronized (this) {
					
					while(list.size()==capacity){
						wait(100);
					}
					
					
					System.out.println("Producer produced: "+value);
					list.add(value++);
					notify();
					Thread.sleep(1000);
				}
			}
			
		}
		
		
		public void consume() throws InterruptedException{
			while(true){
				synchronized (this) {
					while(list.size()==0){
						wait();
					}
					
					
					int value=list.remove(0);
					System.out.println("Consumed ::"+value);
					
					notify();
					Thread.sleep(1000);
					
				}
			}
		}
	}

}
