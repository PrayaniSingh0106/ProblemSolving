package PracticeI;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> compl = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		int index = 0;

		for (int i : nums) {

			if (compl.containsKey(i)) {
				res[0] = compl.get(i);
				res[1] = index;
			}

			else {
				compl.put(target - i, index);
			}

			index++;
		}

		return res;
	}
}
