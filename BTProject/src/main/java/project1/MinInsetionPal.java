package project1;

public class MinInsetionPal {

	public static boolean checkPalidrom(StringBuilder sb) {
		StringBuilder sbr = new StringBuilder(sb);
		sbr.reverse();
		System.out.println(sb);
		if (sbr.toString().equals(sb.toString()))
			return true;

		return false;
	}
	
	public static int getMinPalidromStr(String str){
		
		StringBuilder sb=new StringBuilder(str);
		int size=str.length();
		int count=0;
		if(checkPalidrom(sb))
			return 0;
		
		for(int i=0;i<str.length();i++){
			
			String ch=str.substring(i, i+1);
			sb.insert(size, ch);
			count++;
			if(checkPalidrom(sb))
				break;
		}
		return count--;
	}
	
	public static int findMinInsertions(char[] ch,int l,int h){
	
		if(l>h)
			return Integer.MAX_VALUE;
		if(l==h)
			return 0;
		
		if(ch[l]==ch[h]){
			return findMinInsertions(ch,l+1,l-1);
		}else{
			return Math.min(findMinInsertions(ch,l,h-1),findMinInsertions(ch,l+1,h)+1);
		}
	}

	public static void main(String[] args) {

		String s1 = "geeks";
		System.out.println(getMinPalidromStr(s1));
		
	}
}
