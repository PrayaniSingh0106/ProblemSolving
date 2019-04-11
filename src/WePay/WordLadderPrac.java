package WePay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderPrac {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	      
	        Set<String> begS = new HashSet<String>();
	        Set<String> endS = new HashSet<String>();
	        Set<String> visited = new HashSet<String>();
	        int progress = 1;
	        
	        if(!wordList.contains(endWord))
	            return 0;
	        
	        begS.add(beginWord);
	        endS.add(endWord);
	        
	        while(!begS.isEmpty() && !endS.isEmpty()){
	            
	            Set<String> temp = new HashSet<String>();
	            
	            if(endS.size()<begS.size()){
	                Set<String> x = begS;
	                begS = endS;
	                endS = x;
	            }
	            
	           for(String word: begS){
	               
	               char[] cArr = word.toCharArray();
	            
	               for(int i=0;i<cArr.length;i++){
	              
	                for(char c='a';c<='z';c++){
	                  char old = cArr[i];
	                    cArr[i] = c;
	                    String target = String.valueOf(cArr);
	                    
	                    if(endS.contains(target))
	                        return progress+1;
	                    
	                    if(wordList.contains(target) && !visited.contains(target)){ //why? how is it ensuring shortest path?
	                        visited.add(target);
	                        temp.add(target);
	                    }
	                    cArr[i] = old; //ok?
	                }
	             }
	           }
	            progress++;
	            begS =temp; //why? 
	        }
	       return 0; 
	    }
}
