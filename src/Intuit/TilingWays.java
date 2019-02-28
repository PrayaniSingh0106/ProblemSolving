package Intuit;

public class TilingWays {

	public static int CountTilngWays(int n) {
		
		int count[] = new int[n+2];
		
		count[0] = 0;
		count[1] = 1;
		count[2] = 2;
		
		for(int i=3;i<=n;i++) {
			count[i] = count[i-1] + count[i-2];
		}
		
		//int count = CountTilngWays(n-1) + CountTilngWays(n-2);
		
		return count[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(CountTilngWays(4));
	}

}
