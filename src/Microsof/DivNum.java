package Microsof;

public class DivNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		div(9, 9);
	}

	static void div(int n, int k) {

		int count = 0;
		if (k == 0)
			count = 0;

		else {
			while (n >= k) {
				n -= k;
				count++;
			}
		}
		
		System.out.println("dev " + count);
	}
}
