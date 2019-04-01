package WePay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class MinWindSubS {

	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		Map<Character, Integer> dicT = new HashMap<Character, Integer>();
		int reqSize = 0;

		for (int i = 0; i < t.length(); i++) {
			char x = t.charAt(i);
			int count = dicT.getOrDefault(x, 0);
			dicT.put(t.charAt(i), count + 1);
		}
		reqSize = dicT.size();

		List<Pair<Integer, Character>> selectedString = new ArrayList<Pair<Integer, Character>>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (dicT.containsKey(c))
				selectedString.add(new Pair<Integer, Character>(i, c));
		}

		int r = 0, l = 0, formed = 0;

		Map<Character, Integer> windowChars = new HashMap<Character, Integer>();
		int[] ans = { -1, 0, 0 };

		while (r < selectedString.size()) {
			char c = selectedString.get(r).getValue();
			int count = windowChars.getOrDefault(c, 0);
			windowChars.put(c, count + 1);

			if (dicT.containsKey(c) && windowChars.get(c).intValue() == dicT.get(c).intValue()) {
				formed++;
			}

			while (l <= r && formed == reqSize) {
				c = selectedString.get(l).getValue();

				int end = selectedString.get(r).getKey();
				int start = selectedString.get(l).getKey();

				if (ans[0] == -1 || end - start + 1 < ans[0]) {
					ans[0] = end - start + 1;
					ans[1] = start;
					ans[2] = end;
				}
				windowChars.put(c, windowChars.get(c) - 1);

				if (dicT.containsKey(c) && windowChars.get(c).intValue() < dicT.get(c).intValue())
					formed--;

				l++;
			}

			r++;
		}

		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
