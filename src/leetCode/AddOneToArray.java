package leetCode;

public class AddOneToArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {0, 3, 7, 6, 4, 0, 5, 5, 5};
		int[] B = plusOne(A);
		for(int n: B)
		System.out.println(n + " ");
		
	}
	
	 public static int[] plusOne(int[] A) {
	    
	        int n = A.length;
	        int[] plusOne = new int[n + 1];
	        int carry = 0;
	        int sum = 0;
	        int digit = 0;
	        int flag = 0;
	         int end = 0 ;
	         int temp; 
	           int start = 0;
	        
	         
	         if(A.length == 1){
	             A[0] = A[0] + 1;
	             return A;
	         }
	         
	        for(int i=0; i<n; i++){
	            sum = carry + A[n-i-1]+1;
	            
	            if(sum>9){
	                carry = 1;
	                digit = 0;
	                flag = 1;
	            }
	            else{
	            carry = 0;
	            digit = sum;
	            flag = 0;
	            }
	            
	        }
	        if(flag == 1){
	             sum = A[n-1]+1; 
	             carry = 1;
	             
	            for(int i=0; i<n; i++){
	            	 sum = A[n-i-1] + carry;
	  	            
	            if(sum>9){
	                carry = 1;
	                digit = 0;
	                
	            }
	            else{
	             digit = A[n-i-1] + carry;
	             carry = 0;
	            }
	            plusOne[i] = digit;
	               
	            }
	            plusOne[n] = 1;
	            end = n;
	        }
	        
	        else {
	            sum = A[n-1]+1; 
	            carry = 1;
	            
	        for(int i=0; i<n; i++){
	        	 sum = A[n-i-1] + carry;
		              
	            if(sum>9){
	                carry = 1;
	                digit = 0;
	            }
	            else{
	                
	            digit = A[n-i-1] + carry;
	             carry = 0;
	           
	            }
	            
	            
	            A[n-i-1] = digit;
	        
	        }
	        return A;
	        }
	        
	        while (start < end) 
	        { 
	            temp = plusOne[start];  
	            plusOne[start] = plusOne[end]; 
	            plusOne[end] = temp; 
	            start++; 
	            end--; 
	        }  
	        
	    
	        return plusOne;
	    }
	}
