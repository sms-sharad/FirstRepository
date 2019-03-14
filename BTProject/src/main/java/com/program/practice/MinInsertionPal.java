package com.program.practice;

public class MinInsertionPal {

	public static void main(String[] args) {

		String orgnStr = "abc";

/*		*/
		
		String palStr=orgnStr;
		for(int i=0;i<orgnStr.length();i++){
			
			String s1=orgnStr.substring(i, i+1);
			
			palStr=palStr+s1;
			
		}
	}
	
	public boolean checkPalidrom(String str)
	{
		StringBuilder sb = new StringBuilder(str);
		return str.equals(sb.reverse().toString());
	}
}
