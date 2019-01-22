package matrixMult;

class Solution1 {
    public int solution(String S) {
        // write your code in Java SE 8
        int n = Integer.parseInt(S, 2);
		int count = 0;

		while (n > 0) {
			count++;
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
			}
		}
		return count;
    }
}
