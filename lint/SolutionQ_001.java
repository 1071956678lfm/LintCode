package 刷题;

public class Solution {

	/**
	 * @param a:
	 *            An integer
	 * @param b:
	 *            An integer
	 * @return: The sum of a and b
	 * 
	 *          思路： 1.把进位和相加分割开来 2. 加法实质上做了这么几个操作：忽略进位地相加，再去加上进位值
	 */
	public static int aplusb(int a, int b) {
		int result, carry;

		result = a ^ b;
		carry = (a & b) << 1;
		return result + carry;
	}
}

class Test {
	public static void main(String[] args) {
		System.out.println(Solution.aplusb(0, 2));
	}
}