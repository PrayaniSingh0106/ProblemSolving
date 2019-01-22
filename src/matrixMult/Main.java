package matrixMult;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] p = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			int value = sc.nextInt();
			p[i] = value;
		}

		minChainMatrxMultplc(n + 1, p);

	}

	public static void minChainMatrxMultplc(int n, int[] p) {

		int m[][] = new int[n][n];
		int s[][] = new int[n][n];

		int i, j, k, q;

		for (i = 1; i < n; i++)
			m[i][i] = 0;

		for (int l = 2; l < n; l++) // l is the chain length
		{
			for (i = 1; i < n - l + 1; i++) {
				j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				if (j == n)
					continue;
				for (k = i; k <= j - 1; k++) {
					q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;

					}

				}
			}
		}
		System.out.println(m[1][n - 1]);
		printOptimalParens(s, 1, n - 1);
		System.out.print("\n");

	}

	public static void printOptimalParens(int[][] s, int i, int j) {

		if (i == j)
			System.out.print(i);
		else {
			System.out.print("(");
			printOptimalParens(s, i, s[i][j]);
			printOptimalParens(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}

}
