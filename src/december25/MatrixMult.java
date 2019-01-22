package december25;

import java.util.ArrayList;
import java.util.List;

public class MatrixMult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(5);
		c.add(10);
		c.add(15);
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(12);
		d.add(51);
		d.add(8);
		d.add(6);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(45);
		e.add(7);
		e.add(4);
		e.add(9);
		ArrayList<Integer> f = new ArrayList<Integer>();
		f.add(11);
		f.add(2);
		f.add(33);
		f.add(20);

		ArrayList<ArrayList<Integer>> sources = new ArrayList<ArrayList<Integer>>();
		sources.add(c);
		sources.add(d);
		sources.add(e);
		sources.add(f);

		rotate(sources);
	}

	public static void rotate(ArrayList<ArrayList<Integer>> a) {

		int N = a.size();

		for (int x = 0; x < N / 2; x++) {

			for (int y = x; y < N - x - 1; y++) {

				int right = a.get(y).get(N - 1 - x);
				int bottom = a.get(N - 1 - x).get(N - 1 - y);
				int left = a.get(N - 1 - y).get(x);
				int top = a.get(x).get(y);

				int temp = right;
				// top to right
				a.get(y).set(N - 1 - x, top);
				// left to top
				a.get(x).set(y, left);
				// bottom to left
				a.get(N - 1 - y).set(x, bottom);
				// bottom to temp
				a.get(N - 1 - x).set(N - 1 - y, temp);
			}
		}

	}

}
