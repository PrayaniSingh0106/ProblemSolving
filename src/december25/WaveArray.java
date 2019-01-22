package december25;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = {1,4,5,2,6};
		
		int a[] = wave(x);
		
		for(int i : a) {
			System.out.println(i + "\n");
		}
		
	}
	
	public static int[] wave(int[] A) {
	    
        ArrayList<Integer> sortList = new ArrayList<Integer>();
        int[] arr = new int[A.length]; 
        
        int temp = 0;
        int a = 0;
        int k=0;
        
        for(int x:A) {
        	sortList.add(x);
        	k++;
        }
        
        Collections.sort(sortList);
        
        for(int i=0; i<sortList.size()-1;i = i+2)
        {
            temp= sortList.get(i);
            a = sortList.get(i+1);
            sortList.set(i+1,temp);
            sortList.set(i,a);
        }
        
        int j=0;
       
        for(int x: sortList) {
    	   arr[j] = x;
    	   j++;
       }
       
        System.out.println(" arr[0] " + arr[0] + " arr[1] " + A[1] + " arr[2] " + A[2]);
    
        return arr;
    }
}
