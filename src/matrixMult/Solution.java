package matrixMult;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int j = 0;
		
		
		int count = 1;
		if(A.length == 2 && A[0] == A[1]) {
			return count;
		}
		
		while(j < A.length-1 && A[j] == A[j+1]) {
			j++;
		}
        
        count = 2;
	
        if(j < A.length -1){
        
		int toggle = (A[j+1] > A[j]) ? 1 : -1;
		
			
		for(int i = j+1; i < A.length-1; i++) {
		
			int diff = A[i+1] - A[i];
			
			if(diff * toggle < 0) {
				toggle *= -1;
				count ++;
			}
			
			
		}
        }
		return count; 
      
    }
}


