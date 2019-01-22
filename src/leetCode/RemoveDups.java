package leetCode;

public class RemoveDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 1, 2 ,3,3};

		int size = removeDuplicates(nums);
		System.out.println("Size: " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(" i :" + i + " nums[i] " + nums[i]);
		}
	}

	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	
	}
}
