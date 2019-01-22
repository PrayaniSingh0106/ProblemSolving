package leetCode;

public class CommonStringPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = new String[] { "flower", "flow", "flight" };
		// s[2] = "heyo";
		System.out.println("The longest string is: " + longestCommonPrefix(s));
	}

	public static String longestCommonPrefix(String[] strs) {

		StringBuilder s = new StringBuilder();
		String[] arrStr = strs;
		int flag = 1;

		int minLen = minLength(arrStr);
		int index = 0;

		for (int i = 0; i < arrStr.length - 2; i++) {

			for (int j = 0; j < minLen; j++) {

				System.out.println("arrStr[i].charAt(j) " + arrStr[i].charAt(j));

				if (arrStr[i].charAt(j) == arrStr[i + 1].charAt(j)) {
					System.out.println("arrStr[i+1]: " + arrStr[i + 1] + " for i + 1 : " + (i + 1));
					flag = 0;
					index = j + 1;
				} else {
					arrStr[i + 1] = arrStr[i + 1].substring(0, j);
					index = i + 1;
					System.out.println("arrStr[i+1]: " + arrStr[i + 1] + " for i : " + i);
					// flag = 1;
					break;
				}

			}
			if (flag == 0) {
				arrStr[i + 1] = arrStr[i + 1].substring(0, index);
				index = i + 1;
			}

		}

		return arrStr[index];
	}

	private static int minLength(String[] arrStr) {
		int minL = arrStr[0].length();
		for (int i = 1; i < arrStr.length; i++) {

			if (arrStr[i].length() < minL) {
				minL = arrStr[i].length();
			} else
				continue;
		}

		return minL;
	}

}
