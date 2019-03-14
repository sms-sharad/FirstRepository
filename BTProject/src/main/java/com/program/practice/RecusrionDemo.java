package com.program.practice;

public class RecusrionDemo {
	
	
	public static int sum(int n){
		int sum=n;
		if(n>0){
			sum=sum+sum(n-1);
		}
		return sum;
	}
	
	
	public static void main(String[] args) {

		System.out.println(sum(10));
	}

}
