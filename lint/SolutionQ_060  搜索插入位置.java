package Ë¢Ìâ;

public class SolutionQ_060 {
	/**
	 * @param A:
	 *            an integer sorted array
	 * @param target:
	 *            an integer to be inserted
	 * @return: An integer
	 */
	public static int searchInsert(int[] A, int target) {
		return Method_1(A, 0, A.length, target);
	}

	private static int Method_1(int[] a, int left, int right, int target) {
		int center = (left + right) / 2;

		if (left == right)
			return left ;
		if (left < right) {
			if (a[center] == target)
				return center;
			else if (a[center] > target)
				return Method_1(a, left, center - 1, target);
			else
				return Method_1(a, center + 1, right, target);
		} else
			return left;
	}
}

class Test_060 {
	public static void main(String[] args) {
		int[] A = { 1,3,5,6 };
		System.out.println(SolutionQ_060.searchInsert(A,0));
	}
}