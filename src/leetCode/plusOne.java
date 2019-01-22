package leetCode;

public class plusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] dig = new int[] {9,9,9};
		int[] plusone = plusOne(dig);
		for(int i = 0; i<plusone.length; i++) {
			System.out.println("i: " + i + " th digit " + plusone[i] );
		}
	}

	    public static int[] plusOne(int[] digits) {
	        
	        int max= digits.length;
	        int[] plusone = new int[max];
	        int[] plusoneExtra = new int[max+1];
	        int val = 0; 
	        int carry = 0;
	        boolean addEl = false;
	        
	        val = digits[max-1] + 1;
	        
	        if(val>9){
                val = val%10 ;
                plusone[max-1] = val; 
                carry = 1;
	       } 
	        
	        else
	        	plusone[max-1] = val; 	
	        
	        for(int i = max-2; i>=0 ; i--){
	            
	        	if(i==0 && digits[i]+carry>9) {
	        		break;
	        	}
	           
	           
	        	plusone[i] = digits[i] + carry;
	             
	        	if(plusone[i] > 9) {
	        	carry = 1;
	        	plusone[i] = 0;
	        	}
	        	else
	        		carry = 0;
	
	        }
	        
	        if(carry == 1) {
	        	int j = 1;
	        	
	        	while(j<max) {
	        		plusoneExtra[j+1] = plusone[j];
	        		j++;
	        	}
	        	plusoneExtra[0] = carry;
	        	
	        	return plusoneExtra;
	        }
	        
	        return plusone;
	        
	    }
	}
	
