package ˢ��;

public class Solution {

	/**
	 * @param a:
	 *            An integer
	 * @param b:
	 *            An integer
	 * @return: The sum of a and b
	 * 
	 *          ˼·�� 1.�ѽ�λ����ӷָ�� 2. �ӷ�ʵ����������ô�������������Խ�λ����ӣ���ȥ���Ͻ�λֵ
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