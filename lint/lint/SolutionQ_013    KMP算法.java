package lint��;

public class SolutionQ_013 {
	/*
	 * @param source: source string to be scanned.
	 * 
	 * @param target: target string containing the sequence of characters to match
	 * 
	 * @return: a index to the first occurrence of target in source, or -1 if target
	 * is not part of source.
	 */
	public static int strStr(String source, String target) {
		// return Method_Normal(source, target);
		return Method_KMP_algtho(source, target);

	}

	/*
	 * KMP�㷨 ���������ı���Sƥ�䵽 i λ�ã�ģʽ��Pƥ�䵽 j λ�� ���j = -1�����ߵ�ǰ�ַ�ƥ��ɹ�����S[i] ==
	 * P[j]��������i++��j++������ƥ����һ���ַ��� * ���j != -1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���S[i] != P[j]�������� i ���䣬j =
	 * next[j]�� �˾���ζ��ʧ��ʱ��ģʽ��P������ı���S�����ƶ���j - next [j] λ�� ����֮����ƥ��ʧ��ʱ��ģʽ�������ƶ���λ��Ϊ��
	 * ʧ���ַ�����λ�� - ʧ���ַ���Ӧ��next ֵ��next ��������������ĵ�3.3.3������ϸ�������� ���ƶ���ʵ��λ��Ϊ��j -
	 * next[j]���Ҵ�ֵ���ڵ���1�� �ܿ죬��Ҳ����ʶ��next �����ֵ�ĺ��壺����ǰ�ַ�֮ǰ���ַ����У��ж�󳤶ȵ���ͬǰ׺��׺���������next
	 * [j] = k�� ����j ֮ǰ���ַ���������󳤶�Ϊk ����ͬǰ׺��׺�� ��Ҳ��ζ����ĳ���ַ�ʧ��ʱ�����ַ���Ӧ��next
	 * ֵ���������һ��ƥ���У�ģʽ��Ӧ�������ĸ�λ�ã�����next [j] ��λ�ã��� ���next [j] ����0��-1��������ģʽ���Ŀ�ͷ�ַ� ��next
	 * [j] = k �� k > 0�������´�ƥ������j ֮ǰ��ĳ���ַ���������������ͷ���Ҿ���������k ���ַ���
	 */
	private static int Method_KMP_algtho(String source, String target) {
		int str_1_len = source.length();
		int str_2_len = target.length();
		int i = 0, j = 0;
		char[] ch_1 = source.toCharArray();
		char[] ch_2 = target.toCharArray();
		
		while(i<str_1_len&&j<str_2_len) {
			if(j==-1||ch_1[i]==ch_2[j]) {
				i++;
				j++;
			}
			else
				j=
		}
		if(j==str_2_len)
			return i-j;
		else 
			return -1;
	}

	private static int Method_Normal(String source, String target) {
		int str_1_len = source.length();
		int str_2_len = target.length();
		int i = 0, j = 0;
		char[] ch_1 = source.toCharArray();
		char[] ch_2 = target.toCharArray();

		while ((i < str_1_len) && (j < str_2_len)) {
			if (ch_1[i] == ch_2[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if (j == str_2_len)
			return i - j;
		else
			return -1;

	}
}

class Test_013 {
	public static void main(String[] args) {
		System.out.println(SolutionQ_013.strStr(null, "a"));
	}
}
