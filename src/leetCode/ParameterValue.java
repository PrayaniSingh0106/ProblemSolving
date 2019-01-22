package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParameterValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int c = computeParameterVal("P3.");

		List<String> a = new ArrayList<String>();
		a.add("P1:a");
		a.add("P2:b");
		List<String> b = new ArrayList<String>();
		b.add("P1:x");
		b.add("P5:z");
		List<String> c = new ArrayList<String>();
		c.add("P5:w");
		c.add("P2:c");
		List<List<String>> sources = new ArrayList<List<String>>();
		sources.add(a);
		sources.add(b);
		sources.add(c);
		
		List<String> x = computeParameterVal(sources);
		for (String s : x) {
			System.out.println("Source : " + s);
		}

		System.out.println();
	}

	public static List<String> computeParameterVal(List<List<String>> sources) {

		HashMap<String, String> hmap = new HashMap<String, String>();
		String[] keyvalueseparate = new String[10000];
		ArrayList<String> value = new ArrayList<String>();

		int k = 0;

		for (List<String> s : sources) {

			
			for (String st : s) {

				keyvalueseparate = st.split(":");

				if (!hmap.containsKey(keyvalueseparate[k])) {
					hmap.put(keyvalueseparate[k], keyvalueseparate[k + 1]);
				} else {
					String val = hmap.get(keyvalueseparate[k]);
					val = keyvalueseparate[k + 1];
					hmap.put(keyvalueseparate[k], val);
				}

			}
		}

		Iterator it = hmap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			value.add((String) pair.getValue());
		}
		return value;

	}
}
