package audible;

import java.util.Hashtable;

public class RansomChall {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> magazine = new Hashtable<String,		Integer>();
	       
	       for(String s : magazineWords.split(" ")){
	           if(magazine.containsKey(s)){
	               magazine.put(s, magazine.get(s) + 1);
	           }else{
	               magazine.put(s, 1);
	           }
	       }
	        
	       for(String s : ransom){
	           if(!magazine.containsKey(s)){
	              // return "No";
	           }
	           
	           int counter = magazine.get(s) - 1;
	           
	           if(counter == 0){
	               magazine.remove(s);
	           }else{
	               magazine.put(s, counter);
	           }
	       }
	        
	      // return "Yes";
	}

}
