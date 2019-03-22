package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsII {
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> hmap = new HashMap<String, List<String>>();

		int[] count = new int[26];

		for (String a : strs) {
			Arrays.fill(count, 0);

			for (char c : a.toCharArray()) {
				count[c - 'a']++;
			}
			StringBuilder sb = new StringBuilder("");

			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();

			if (!hmap.containsKey(key))
				hmap.put(key, new ArrayList());
			hmap.get(key).add(a);
		}
		return new ArrayList(hmap.values());
	}
}
