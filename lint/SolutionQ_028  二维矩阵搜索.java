package Ë¢Ìâ;
public class SolutionQ_028 {
	/*
	 * @param matrix: matrix, a list of lists of integers
	 * 
	 * @param target: An integer
	 * 
	 * @return: a boolean, indicate whether matrix contains target
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row = matrix.length;
		int column = matrix[0].length;
		int rowOfTarget = rowBinSearch(matrix, 0, row - 1, column, target);
		int colOfTarget = colBinSearch(matrix, 0, column - 1, rowOfTarget, target);
		if (colOfTarget != -1)
			return true;
		else
			return false;
	}

	private static int colBinSearch(int[][] matrix, int left, int right, int rowOfTarget, int target) {
		int mid = (left + right) / 2;
		int result = mid;

		if ((left > right) || (left == right && matrix[rowOfTarget][result] != target))
			return -1;
		if (matrix[rowOfTarget][result] == target)
			return result;
		if (matrix[rowOfTarget][result] > target)
			result = colBinSearch(matrix, left, mid - 1, rowOfTarget, target);
		else
			result = colBinSearch(matrix, mid + 1, right, rowOfTarget, target);
		return result;
	}

	private static int rowBinSearch(int[][] matrix, int left, int right, int column, int target) {
		int mid = (left + right) / 2;
		int row = mid;
		if (left == right)
			return mid;
		if (matrix[left][0] <= target && matrix[left][column - 1] >=target)
			return left;
		if (matrix[right][column - 1] >= target && matrix[right][0] <= target)
			return right;
		if (matrix[mid][column - 1] >= target && matrix[mid][0] >= target)
			return mid;
		if (matrix[mid][column - 1] < target)
			row = rowBinSearch(matrix, mid + 1, right, column, target);
		else
			row = rowBinSearch(matrix, left, mid - 1, column, target);

		return row;
	}

}

class Test {
	public static void main(String[] args) {
		int[][] mar = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(SolutionQ_028.searchMatrix(mar, 3));
	}
}
