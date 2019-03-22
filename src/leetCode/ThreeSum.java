package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {

		int low = 0, high = 0;
		int sum = 0;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length - 1; i++) {

			if (i == 0 || nums[i] != nums[i - 1]) {
				low = i + 1;
				sum = 0 - nums[i];
				high = nums.length - 1;

				while (low < high) {

					if (nums[low] + nums[high] == sum) {

						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1])
							low++;
						while (low < high && nums[high] == nums[high - 1])
							high--;
						low++;
						high--;
					} else if (nums[low] + nums[high] > sum)
						high--;
					else
						low++;
				}
			}
		}

		return res;
	}
}
