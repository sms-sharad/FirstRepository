package com.program.practice;

public class ReachingDestination {

	
	static int steps(int source,int step,int dest){
		
		System.out.println("Source:: ("+source+", "+step+", "+dest+")");
		if (Math.abs(source) > (dest))  
            return Integer.MAX_VALUE; 
		
		if(source==dest)
			return step;
		
		//positive scenerio
		int pos=steps(source+step+1,step+1,dest);
		
		int neg=steps(source-step-1,step+1,dest);
		
		//System.out.println("("+pos+", "+neg+")");
		//return neg;
		return Math.min(pos, neg);
	}
	
	public static void main(String[] args) {
		int dest = 2; 
        System.out.println("No. of steps required"+ " to reach " + dest + " is " + steps(0, 0, dest));
        //System.out.println(Math.sqrt(9));
	}
}
