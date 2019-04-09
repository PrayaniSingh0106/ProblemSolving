package WePay;

public class FirstBadVersion {
	/*
	 * The isBadVersion API is defined in the parent class VersionControl. boolean
	 * isBadVersion(int version);
	 */

	public int firstBadVersion(int n) {

		int start = 1, end = n;
		int mid;

		while (start < end) {
			mid = start + (end - start) / 2;

			if (!isBadVersion(mid)) {
				start = mid + 1;
			} else
				end = mid;
		}

		return start;
	}
}
