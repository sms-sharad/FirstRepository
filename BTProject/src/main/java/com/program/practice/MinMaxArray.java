package com.program.practice;

import java.util.Arrays;

public class MinMaxArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1,2,3,4,5,6 };

		int count = 0;
		int sum = 0;
		int[] minMax = new int[arr.length];
		int next = 0;
		int limit=arr.length-1;
		for (int i = 0; i < arr.length; i++) {
			
			//for (int j = i; j < arr.length; j++) {
				if (count < limit) {
					sum = sum + arr[i];
					++count;
					
					if (count == limit) {
						minMax[next++] = sum;
					}
				}
				if (i == limit) {
					i = -1;
					sum = 0;
					count = 0;
				}
			//}
		}
		Arrays.sort(minMax);
		System.out.println(minMax[0] + " " + minMax[minMax.length - 1]);
	}

}
