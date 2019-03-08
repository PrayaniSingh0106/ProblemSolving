package leetCode;

public class RotateImage {
	public void rotate(int[][] matrix) {

		int row = matrix.length;
		int column = matrix[0].length;
		System.out.println("Matrix row: " + row);
		int temp = 0;

		for (int i = 0; i < row; i++) {

			for (int j = i; j < column; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][row - j - 1];
				matrix[i][column - j - 1] = temp;
			}
		}
	}
}
