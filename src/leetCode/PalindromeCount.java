package leetCode;

public class PalindromeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c = countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb");
		System.out.println(c);
	}

	public static int countSubstrings(String s) {

		int n = s.length();
		int left = 0;
		int right = 0;
		int countPalin = 0;
		int flag = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n - i - 1; j++) {
				left = j - i - 1;
				right = j + i + 1;

				System.out.println("i: " + i + " j : " + j);
				
				if (s.charAt(left) == s.charAt(right)) {
					
					while (left < right) {
						
						if (s.charAt(left) != s.charAt(right)) {
							flag = 0;
							break;
						} else {
							flag=1;
							left++;
							right--;
						}
					}
				}
				
				if(flag == 1) {
					countPalin++;
				}
				flag = 0;
			
			}
			for (int k = i * 2 + 1; k < n; k = k + 1) {

				left = k / (1 + i) - 1;
				right = k;

				if (s.charAt(left) == s.charAt(right)) {
					
					while (left < right) {
						if (s.charAt(left) != s.charAt(right)) {
							flag = 0;
							break;
						} else {
							flag=1;
							left++;
							right--;
						}

					}
					
				}
				if(flag == 1) {
					countPalin++;
				}
				flag = 0;
			
			}

		}
		System.out.println("Count palin : " + countPalin);
		
		return countPalin + n;
	}

}
