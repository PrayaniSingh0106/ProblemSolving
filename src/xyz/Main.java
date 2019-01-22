package xyz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int l = Integer.parseInt(sc.next());
		int[] denomination = new int[l];

		for (int i = 0; i < l; i++) {
			int value = sc.nextInt();
			denomination[i] = value;
		}

		System.out.println(minCoinChange(denomination, l, N));
	}

	 static int minCoinChange(int denom[], int l, int N) {

		int memo[] = new int[N + 1];

		memo[0] = 0;

		for (int k = 1; k <= N; k++) {
			memo[k] = Integer.MAX_VALUE;

		}

		for (int i = 1; i <= N; i++) {

			for (int j = 0; j < l; j++) {

				if (denom[j] <= i) {

					int intermediateRes = memo[i - denom[j]];
					
					if (intermediateRes != Integer.MAX_VALUE && intermediateRes + 1 < memo[i])
						memo[i] = intermediateRes + 1;
				}

			}

		}
		return memo[N];
	}
}
