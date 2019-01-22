package Microsof;

public class StringRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rev("geeks for geeks");
	}
	
	public static void rev(String s) {
		
		int l=s.length();
		char[] c=s.toCharArray();
		char x;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<l/2;i++) {
			
			x=c[i];
			c[i]=c[l-i-1];
			c[l-i-1]=x;
			
		}
		
		for(char i:c) {
			sb.append(i);
		}
		System.out.println("sb " + sb);
	}

}
