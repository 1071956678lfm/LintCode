package 刷题;

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
	 * KMP算法 假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置 如果j = -1，或者当前字符匹配成功（即S[i] ==
	 * P[j]），都令i++，j++，继续匹配下一个字符； * 如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j =
	 * next[j]。 此举意味着失配时，模式串P相对于文本串S向右移动了j - next [j] 位。 换言之，当匹配失败时，模式串向右移动的位数为：
	 * 失配字符所在位置 - 失配字符对应的next 值（next 数组的求解会在下文的3.3.3节中详细阐述）， 即移动的实际位数为：j -
	 * next[j]，且此值大于等于1。 很快，你也会意识到next 数组各值的含义：代表当前字符之前的字符串中，有多大长度的相同前缀后缀。例如如果next
	 * [j] = k， 代表j 之前的字符串中有最大长度为k 的相同前缀后缀。 此也意味着在某个字符失配时，该字符对应的next
	 * 值会告诉你下一步匹配中，模式串应该跳到哪个位置（跳到next [j] 的位置）。 如果next [j] 等于0或-1，则跳到模式串的开头字符 若next
	 * [j] = k 且 k > 0，代表下次匹配跳到j 之前的某个字符，而不是跳到开头，且具体跳过了k 个字符。
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
