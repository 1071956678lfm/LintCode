package Ë¢Ìâ;

import java.util.LinkedList;
import java.util.List;

public class SolutionQ_082 {
	/**
	 * @param A:
	 *            An integer array
	 * @return: An integer
	 */
	public static int singleNumber(int[] A) {
		int result;
		result = A[0];
		List<Integer> list = new LinkedList<>();
		list.add(result);
		if (A.length == 1)
			return result;
		for (int index = 1; index < A.length; index++) {
			if (list.contains(A[index]))
				list.remove(list.indexOf(A[index]));
			else
				list.add(A[index]);
		}
		return list.get(0);
	}
}

class Test {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3, 4, 4 };
		System.out.println(SolutionQ_082.singleNumber(nums));
	}
}