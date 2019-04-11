package WePay;

import java.util.Stack;

public class CalculatorII {
	public int calculate(String s) {
		//COMPLEXITY: O(n)
		int res = 0;
		int num = 0;
		int sign = 1;
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {

			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + Character.getNumericValue(s.charAt(i));
			} else if (!(Character.isDigit(s.charAt(i))) && s.charAt(i) != ' ') {
				Character c = s.charAt(i);

				if (c == '-') {
					res = res + num * sign;
					num = 0;
					sign = -1;
				}
				if (c == '+') {
					res = res + num * sign;
					num = 0;
					sign = 1;
				}
				if (c == '(') {
					st.push(res);
					st.push(sign);
					res = 0;
					sign = 1;
				}
				if (c == ')') {
					res = res + num * sign;
					num = 0;
					res = res * st.pop();
					res = res + st.pop();

				}
			}
		}

		if (num != 0) {
			res = res + num * sign;
		}

		return res;
	}
}
