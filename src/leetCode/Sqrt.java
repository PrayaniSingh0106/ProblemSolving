package leetCode;

public class Sqrt {
	 
	
	public static void main(String args[]) throws Exception {
	
		System.out.println("mySqrt " + Sqrt.mySqrt(2147395599));
	}
		   
	public static int mySqrt(int x) {
	       
	        int start = 0;
	        int end = x;
	        int mid = 0;
	        int answer = 0;
	        while(start <= end){
	            
	        	mid = start + (end - start) / 2;//mid = (start+end)/2; this will give overflow
	          
	            if(mid*mid > x){
	                end = mid -1;
	                
	            }
	            
	            else if(mid*mid <= x){
	                start = mid + 1;
	            }
	            
	            
	            if(mid*mid <= x){
	                answer = mid;
	            }
	            
	        }
	        
	        return answer;
	        
	    }
	}
