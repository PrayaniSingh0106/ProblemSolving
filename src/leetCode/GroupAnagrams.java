package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> hmap = new HashMap<String, List<String>>();

		for (String a : strs) {
			char[] arr = a.toCharArray();
			Arrays.sort(arr);
			String keyStr = String.valueOf(arr);

			if (!hmap.containsKey(keyStr)) {
				hmap.put(keyStr, new ArrayList<String>());
			}
			hmap.get(keyStr).add(a);
		}

		return new ArrayList<List<String>>(hmap.values());
	}
}
