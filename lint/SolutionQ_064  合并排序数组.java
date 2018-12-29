package À¢Ã‚;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class SolutionQ_064 {
	/*
	 * @param A: sorted integer array A which has m elements, but size of A is m+n
	 * 
	 * @param m: An integer
	 * 
	 * @param B: sorted integer array B which has n elements
	 * 
	 * @param n: An integer
	 * 
	 * @return: nothing
	 */
	public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
		Method_2(A, m, B, n);
	}

	private static void Method_2(int[] a, int m, int[] b, int n) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < m + n; i++) {
			if (i < m)
				list.add(a[i]);
			else
				list.add(b[i - m]);
		}
		list.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		int i = 0;
		for (Integer num : list) {
			a[i] = num;
			i++;
		}

	}

	@SuppressWarnings("unused")
	private static void Method_1(int[] a, int m, int[] b, int n) {
		if (m == 0)
			a = b;
		for (int i = 0; i < n; i++) {
			int tmpB = b[i];
			for (int j = 0; j < m + i; j++) {
				int tmpA = a[j];
				if (tmpB > tmpA) {
					if (j != m + i - 1)
						continue;
					else {
						a[j + 1] = tmpB;
						break;
					}
				} else {
					LinkedList<Integer> list = new LinkedList<>();
					for (int k = 0; k < m + i; k++)
						list.add(a[k]);
					list.add(j, tmpB);
					for (int k = 0; k < m + i + 1; k++)
						a[k] = list.get(k);
					break;
				}
			}
		}
	}
}

class Test {
	public static void main(String[] args) {
		int[] A = { 1, 3, 4, 6, 0, 0 };
		int[] B = { 2, 5 };
		SolutionQ_064.mergeSortedArray(A, 4, B, 2);
	}
}