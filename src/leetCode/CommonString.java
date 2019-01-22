package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CommonString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "i am programmer and programmer and coder";
		String s2 = "i am programmer and coder";
		uncommonFromSentences(s1, s2);

		/*
		 * for (String m : s) { System.out.println(m + " "); }
		 */

	}

	public static void uncommonFromSentences(String s, String t) {

		String words[] = s.split(" ");
		String words2[] = t.split(" ");
		
		for(int i=0;i<words.length;i++){
            int flag=0;
            for(int j=0;j<words2.length;j++){
                 
                if(words[i].equals(words2[j])){
                    flag=1;
		    words2[j]="";
		    break;
		}
            }
            if(flag==0){
                System.out.print(" "+words[i]);
            }
        }
		System.out.println();
	}
}