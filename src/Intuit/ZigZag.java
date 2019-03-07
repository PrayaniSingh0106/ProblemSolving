package Intuit;

public class ZigZag {
	public String convert(String s, int numRows) {

		int len = s.length();
		System.out.println(len);
		StringBuilder[] sb = new StringBuilder[numRows];

		if (numRows == 1 || numRows > len)
			return s;

		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuilder();
		int i = 0;

		while (i < len) {

			for (int indx = 0; indx < numRows && i < len; indx++) {

				sb[indx].append(s.charAt(i));
				i++;
			}
			for (int indx2 = numRows - 2; indx2 >= 1 && i < len; indx2--) {
				// System.out.println("indx2: " + indx2);
				sb[indx2].append(s.charAt(i));
				i++;
			}
		}

		for (int index = 1; index < numRows; index++)
			sb[0].append(sb[index]);

		return sb[0].toString();
	}
}
