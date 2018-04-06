package Ë¢Ìâ;

public class SolutionQ_056 {
	/**
	 * @param numbers:
	 *            An array of Integer
	 * @param target:
	 *            target = numbers[index1] + numbers[index2]
	 * @return: [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;

		return Method_1(numbers, left, right, target);
	}

	private int[] Method_1(int[] numbers, int left, int right, int target) {
		int center = (left + right) / 2;
		if (left >= right)
			return null;
		if (numbers.length == 2 && numbers[left] + numbers[right] == target)
			return new int[] {left,right};
		int[] leftResult = Method_1(numbers, left, center, target);
		int[] rightResult = Method_1(numbers, center + 1, right, target);
		if (leftResult == null && rightResult == null) {
			for(int i=left;i<=center;i++) {
				for(int j=center+1;j<=right;j++) {
					if(numbers[i]+numbers[j]==target)
						return new int[] {i,j};
				}
			}
		} else if (leftResult != null)
			return leftResult;
		else
			return rightResult;

		return null;
	}
}

class Test_056 {
	public static void main(String[] args) {
	}
}