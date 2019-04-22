package audible;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FirstRareChar {

	public Integer firstLeastOccur(String s) {

		int n = s.length();
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		int lFreq = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			char c = s.charAt(i);
			hmap.put(c, hmap.getOrDefault(c, 0) + 1);

			if (hmap.get(c) < lFreq) {
				lFreq = hmap.get(c);
			}

		}
		ArrayList<Character> arr = new ArrayList<Character>();

		for (int i = 0; i < n; i++) {

			char c = s.charAt(i);

			if (hmap.get(c) == lFreq) {

				arr.add(c);

			}

		}
		int rnd = new Random().nextInt(hmap.size());
		return hmap.get(arr.get(rnd));

	}
}
