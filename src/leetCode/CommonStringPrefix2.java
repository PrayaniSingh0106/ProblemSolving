package leetCode;

public class CommonStringPrefix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = new String[] { "flower", "flow", "flight" };
		// s[2] = "heyo";
		System.out.println("The longest string is: " + longestCommonPrefix(s));
	}

	public static String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";
		
		String prefix = strs[0];
		System.out.println("prefix " + prefix);
		
		for (int i = 1; i < strs.length; i++) {
			
			while (strs[i].indexOf(prefix) != 0 ) {
				System.out.println("strs[i].indexOf(prefix) : " + strs[i].indexOf(prefix) + " strs[i] " + strs[i]
						+ " prefix.length() " + prefix.length());
					
				prefix = prefix.substring(0, prefix.length() - 1);
				
				if (prefix.isEmpty())
					return "";
			}
	}
		return prefix;

	}

}
