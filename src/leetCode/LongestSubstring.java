package leetCode;

import java.util.ArrayList;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {

		ArrayList<Character> listChar = new ArrayList<Character>();
		int max = 0, count = 0;

		if (s.length() == 1) {
			return 1;
		}

		for (int i = 0; i < s.length(); i++) {

			if (!listChar.contains(s.charAt(i))) {
				listChar.add(s.charAt(i));
				count++;

			}
			

			else {

				if (count > max) {
					max = count;
				}
				i = s.indexOf(s.charAt(i));
				listChar.clear();
				count = 0;

			}

		}

		if (count > max) {
			max = count;
		}
		return max;
	}
}
