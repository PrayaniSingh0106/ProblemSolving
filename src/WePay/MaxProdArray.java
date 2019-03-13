package WePay;

public class MaxProdArray {
	public int maxProduct(int[] nums) {

		int globalMaxProd = nums[0];

		for (int i = 1, maxProd = globalMaxProd, minProd = globalMaxProd; i < nums.length; i++) {

			if (nums[i] < 0) {
				int temp = maxProd;
				maxProd = minProd;
				minProd = temp;
			}

			maxProd = Integer.max(nums[i], maxProd * nums[i]);
			minProd = Integer.min(nums[i], minProd * nums[i]);
			globalMaxProd = Integer.max(globalMaxProd, maxProd);
		}

		return globalMaxProd;
	}
}
