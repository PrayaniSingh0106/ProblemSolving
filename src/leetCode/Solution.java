package leetCode;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		// read the string filename
		String filename;

		int[] a = flip("010");
		for (int x : a) {
			System.out.println(x + " ");
		}
	}

	public static int[] flip(String A) {

		 int[] bits = new int[A.length()];
	        int[] bitCpy = new int[A.length()];
	        int[] lr = new int[2];
	        int flag = 0,sum=0;
	        int[] empty = {};

	        int count = 0, max = Integer.MIN_VALUE;

	        for (int i = 0; i < A.length(); i++) {
	            bits[i] = A.charAt(i) - '0';
	        }

	        for (int i = 0; i < A.length(); i++) {
	            if (bits[i] == 1) {
	                count++;
	            }
	        }
	        if (count == bits.length)
	            return empty;
	        else
	            count = 0;
	        bitCpy = bits;
	        
	        for(int i=0;i<bitCpy.length;i++){
	            if(bitCpy[i]==1)
	                bitCpy[i]=-1;
	        }
	        
	        for(int i=0;i<bitCpy.length;i++){
	        
	            if(sum<0){
	                sum=bitCpy[i];
	                lr[0]=i+2;
	            }
	            else{
	                sum+=bitCpy[i];
	            }
	            if(sum>max){
	            max=sum;
	            lr[1] = i+1;
	            }
	        }
	      
	      return lr; 
	}

}
