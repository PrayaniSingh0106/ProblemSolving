package leetCode;

public class NeedleinHays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Index = " + strStr("bbaa", "aab"));
	}
	
	public static int strStr(String haystack, String needle) {
		int flag = -1, index = 0, jc =0 ;
		if (needle == "" || needle.isEmpty())
			return 0;

		else if (haystack.length() < needle.length())
			return -1;
		
		else if(haystack.equals(needle))
			return 0;
		
		else {

			int i = 0, k = 0;
			while (i < haystack.length()) {
				int j = 0;
				k = i;
				while (j < needle.length()) {

					System.out.println("haystack.charAt(k) : " + haystack.charAt(k));
					System.out.println("eedle.charAt(j) : " + needle.charAt(j));
						
					if (haystack.charAt(k) == needle.charAt(j)) {
						System.out.println("true");
						if (k < haystack.length() - 1)
							k++;
						else if(j!=needle.length()-1) {
							flag = -1;
							break;
						}
						else break;
						j++;
						jc = j;
						flag = 0;
					} else {
						flag = -1;
						break;
					}

				}
				if (flag == 0 && jc == needle.length()-1 || jc == needle.length()) {
					index = k - jc;
					return index;
				}
				i++;
			}

		}
		return flag;

	}

}
