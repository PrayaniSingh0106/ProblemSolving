package WePay;

import java.util.Stack;

public class Calculator {
	//COMPLEXITY: O(n)
	public int calculate(String s) {

		Stack<Integer> st = new Stack<Integer>();
		int res = 0;
		int sign = '+';
		int num = 0;
		int n = s.length();
		int count = 0;

		for (Character ch : s.toCharArray()) {
			count++;
			if (Character.isDigit(ch)) {
				num = num * 10 + Character.getNumericValue(ch);
			}
			// System.out.println("count: " + count +" n: " + n);
			if (!Character.isDigit(ch) && ' ' != ch || count == n) {

				if (sign == '-')
					st.push(-num);
				if (sign == '+')
					st.push(num);

				if (sign == '*') {
					int x = st.pop();
					st.push(num * x);
				}
				if (sign == '/') {
					int x = st.pop();
					st.push(x / num);
				}
				sign = ch;
				num = 0;
			}

		} // end of outer for

		for (Integer i : st) {
			res += i;
		}
		return res;
	}

}
