package WePay;

public class MaxSumCtgsArr {

	public int MaxSum(int[] A) {

		int maxSumCurr = A[0];
		int globalSum = A[0];

		for (int i = 0; i < A.length; i++) {

			maxSumCurr = Integer.max(A[i], maxSumCurr + A[i]);

			if (maxSumCurr > globalSum) {
				globalSum = maxSumCurr;
			}

		}

		return globalSum;
	}

	public static void main(String[] args) {
		MaxSumCtgsArr m = new MaxSumCtgsArr();

		int[] arr = { -2, 3, 2, -1 };
		System.out.println(m.MaxSum(arr));
	}
}
