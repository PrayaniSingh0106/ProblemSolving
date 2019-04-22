package audible;

import java.util.ArrayList;
import java.util.Iterator;

public class MakePalin {

	// Given a string, remove the minimum characters such that the string could be
	// converted to a palindrome. List the characters as output

	public static void RemvChar(String s) {

		int n = s.length();
		ArrayList<Character> arr = new ArrayList<Character>();
		int i = 0, j = n-1;

		while (i <j) {

			System.out.println("s.charAt(i) " + s.charAt(i));
			System.out.println("s.charAt(j) " + s.charAt(j));

			if (s.charAt(i) != s.charAt(j)) {
				arr.add(s.charAt(j));
				System.out.println("s.charAt(j) " + s.charAt(j) + " J " + j);
				j--;
			} else {
				i++;
				j--;
			}
		}

		Iterator<Character> iter = arr.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	public static void main(String args[]) {

		RemvChar("malangyalaam");
	}
}
