package leetCode;

import java.util.HashMap;
import java.util.Map;

public class RomantoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("romanToInt : " + romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {

		Map<String, Integer> m = new HashMap<>();
		String sub = "";
		String str = s;
		int len = s.length();
		m.put("I", 1);
		m.put("V", 5);
		m.put("X", 10);
		m.put("L", 50);
		m.put("C", 100);
		m.put("D", 500);
		m.put("M", 1000);
		m.put("IV", 4);
		m.put("IX", 9);
		m.put("XL", 40);
		m.put("XC", 90);
		m.put("CD", 400);
		m.put("CM", 900);

		int num = 0;
		int i = 0;

		while (str != null && !str.isEmpty() && i < len) {

			char c = str.charAt(i);

			if ((c == 'I' || c == 'X' || c == 'C')) {

				if (i <= len - 2) {
					sub = str.substring(i, i + 2);

					if (m.containsKey(sub)) {
						num += m.get(sub);
						i = i + 2;
					}
					else {
						num += m.get(str.substring(i, i + 1));
						i += 1;
					}
				}

				else {
					num += m.get(str.substring(i, i + 1));
					i += 1;
				}
				
			}

			else {
				num += m.get(str.substring(i, i + 1));
				i += 1;
			}

		}
		return num;
	}

}
