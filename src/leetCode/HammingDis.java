package leetCode;

public class HammingDis {
	public int hammingDistance(int x, int y) {

		String a = Integer.toString(x, 2);
		String b = Integer.toString(y, 2);

		int hDist = 0;

		int l1 = a.length();
		int l2 = b.length();
		int diff = Math.abs(l1 - l2);
		int min = Math.min(l1, l2);
		int i = 0;
		for (i = 0; i < min; i++) {
			if (a.charAt(l1 - i - 1) != b.charAt(l2 - i - 1)) {
				hDist++;
			}
		}

		if (l1 > l2) {
			for (int j = i; j < l1; j++) {
				hDist = hDist + Integer.parseInt(String.valueOf(a.charAt(l1 - j - 1)));
			}

		} else if (l2 > l1) {
			System.out.println("i: " + i);

			for (int j = i; j < l2; j++) {
				hDist = hDist + Integer.parseInt(String.valueOf(b.charAt(l2 - j - 1)));
			}
		}
		return hDist;
	}
}
