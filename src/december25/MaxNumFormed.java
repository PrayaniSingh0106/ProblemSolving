package december25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaxNumFormed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String largestNumber(final int[] A) {
		
		for(int x:A) {
			
		}
		int max = 0;
		
		for (int counter = 1; counter < A.length; counter++)
		{
		     if (A[counter] > max)
		     {
		      max = A[counter];
		     }
		}
		
		
		//int max = Arrays.stream(A).max().getAsInt(); 
		return null;
    
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        
		List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
