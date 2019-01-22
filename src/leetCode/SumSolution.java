package leetCode;

import java.util.HashMap;
import java.util.Map;

public class SumSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SumSolution s = new SumSolution();
		int[] nums = new int[]{2,5,5,11};
		int[] res = new int[2];
		res = s.twoSum(nums, 30);
		System.out.println("I and J : " + res.length);
	}
	
	 public int[] twoSum(int[] nums, int target) {
	      
		 	
		 Map<Integer, Integer> map = new HashMap<>();
		 int[] res = new int[2];
		 
		 for(int i=0; i< nums.length; i++)
		 {
			 if(map.containsKey(target - nums[i])) {
				 res[0] = i;
				 res[1] = map.get(target - nums[i]);
				 return res;
 		 }
			 else {
				 map.put(nums[i], i);
			 }
		 }
		 return res;
		 
		 /*int[] index = new int[2];
		 
	        for(int i = 0; i<nums.length; i++) {
	        	
	        	for(int j=i+1; j<nums.length; j++) {
	        		
	        		int sum = nums[i] + nums[j];
	        		
	        		if(target == sum) {
	        			index[0] = i;
	        			index[1] = j;
	        			return index;
	        		}
	        	
	        	}
	        }
			return new int[0];
	        
	    }*/

}
}
