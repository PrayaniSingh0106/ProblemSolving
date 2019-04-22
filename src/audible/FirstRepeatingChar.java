package audible;

import java.util.HashMap;

public class FirstRepeatingChar {
	public int firstUniqChar(String s) {

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		int n = s.length();

		for (int i = 0; i < n; i++) {

			char c = s.charAt(i);
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < n; i++) {

			if (hmap.get(s.charAt(i)) == 1)
				return i;
		}

		return -1;
	}
}
