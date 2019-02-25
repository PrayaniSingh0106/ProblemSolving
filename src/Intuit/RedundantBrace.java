package Intuit;

import java.util.Stack;

public class RedundantBrace {
	// Function to check redundant brackets in a
	// balanced expression

	static boolean checkRedundancy(String s) {

		boolean flag = true;
		Stack<Character> st = new Stack<Character>();
		Character top = null;
		
		for (Character c : s.toCharArray()) {

			if (c == ')') {
				
				top = st.peek();
				st.pop();
				
				flag = true;
				
				while(top!='(') {
				
					if(top=='*'||top=='+'||top=='/'||top=='-') {
						flag=false;
					}
					top = st.peek();
					st.pop();
				}
				if(flag == true)
					return flag;
				
			} else {
				st.push(c);
			}
		}

		return false;
	}

	// Function to check redundant brackets
	static void findRedundant(String str) {
		boolean ans = checkRedundancy(str);
		if (ans == true) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	// Driver code
	public static void main(String[] args) {
		String str = "((a+b))";
		findRedundant(str);

		str = "(a+(b)/c)";
		findRedundant(str);

		str = "(a+b*(c-d))";
		findRedundant(str);
	}
}
