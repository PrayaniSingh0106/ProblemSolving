package xyz;

import java.util.ArrayList;

public class ArrayListPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		ArrayList<Integer> firstR = new ArrayList<>();
		firstR.add(1);
		firstR.add(2);
		firstR.add(3);
		firstR.add(4);
		
		
		ArrayList<Integer> secR = new ArrayList<>();
		secR.add(5);
		secR.add(6);
		secR.add(7);
		secR.add(8);
		
		
		ArrayList<Integer> thirdR = new ArrayList<>();
		thirdR.add(9);
		thirdR.add(10);
		thirdR.add(11);
		thirdR.add(12);
		
		A.add(firstR);
		A.add(secR);
		A.add(thirdR);
		
		ArrayList<ArrayList<Integer>> B = performOps(A);
		System.out.println("Size of arraylist: " + B.size());
		for (int i = 0; i < B.size(); i++) {
			for (int j = 0; j < B.get(i).size(); j++) {
				System.out.println("Array at j " + j + "  " + B.get(i).get(j));
				System.out.print(B.get(i).get(j) + " ");
			}
		}
	}
	
	
	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		return B;
	}

}
