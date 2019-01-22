package leetCode;
import java.util.ArrayList;
import java.util.Collections;

public class AlwaysSortedArrayList {
	private ArrayList<String> list;
	      

	public AlwaysSortedArrayList() { //7
		list = new ArrayList<String>(); //1
	}
	
	public void remove(int index) {
		list.remove(index);
	}
	
	public String get(int index) {
		return list.get(index);
	}
	
	public void add(String s) {
		list.add(s);
		Collections.sort(list); //2
	}
	
	/* set value of string at index to 's' */
	/* corresponds to the ArrayList set method */
	public void set(int index, String s) {
		list.set(index, s);
		Collections.sort(list); //3
	}
	
	public void appendList(ArrayList<String> newlist) {
		list.addAll(newlist);
		Collections.sort(list); //4
	}
	
	public void display() {
		System.out.println("---");
		for (String s : list ) //5
			System.out.println(s);
		System.out.println("---");
	}
	
	public int size() {
		return list.size(); //6
	}
}
