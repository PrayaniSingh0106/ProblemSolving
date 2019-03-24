package leetCode;

import java.util.LinkedList;
import java.util.List;

public class PhoneNum {
	public List<String> letterCombinations(String digits) {

		LinkedList<String> res = new LinkedList<String>();
		if (digits.isEmpty())
			return res;
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		res.add("");

		for (int i = 0; i < digits.length(); i++) {

			int dig = Character.getNumericValue(digits.charAt(i));

			while (res.peek().length() == i) {
				String top = res.remove();
				for (char c : mapping[dig].toCharArray()) {
					res.add(top + c);

				}
			}
		}

		return res;
	}
}
