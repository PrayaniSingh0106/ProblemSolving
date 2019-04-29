package audible;

public class MergeSortedArr {

	public static int[] MergeArr(int[] a1, int[] a2) {

		int[] aMerg = new int[a1.length + a2.length];
		int m1 = 0;
		int m2 = 0;
		int i = 0;

		while (m1 < a1.length && m2 < a2.length) {

			if (a1[m1] < a2[m2]) {
				aMerg[i] = a1[m1];
				m1++;
				i++;
			} else {
				aMerg[i] = a2[m2];
				m2++;
				i++;
			}
		}

		if (m1 < a1.length-1) {
			while (m1 < a1.length) {
				aMerg[i] = a1[m1];
				m1++;
				i++;
			}

		}

		if (m2 < a2.length-1) {
			while (m2 < a2.length) {
				aMerg[i] = a2[m2];
				m2++;
				i++;
			}
		}

		return aMerg;
	}
	
	
	public static void main(String[] args) {
		
		int a[] = {1,3,4,5};
		int b[] = {7,9,10};
		
		int[] c = MergeArr(a,b);
		
		for(int i=0; i<c.length; i++) {
			System.out.println("c : " + c[i]);
		}
		
	}
}
