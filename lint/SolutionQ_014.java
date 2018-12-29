package À¢Ã‚;

public class Solution {
	/*
	 * @param source: source string to be scanned.
	 * 
	 * @param target: target string containing the sequence of characters to match
	 * 
	 * @return: a index to the first occurrence of target in source, or -1 if target
	 * is not part of source.
	 */
	public static int strStr(String source, String target) {
		if (  source == null || target == null||!source.contains(target))
			return -1;
		else
			return source.indexOf(target);

	}
}

class Test {
	public static void main(String[] args) {
		System.out.println(Solution.strStr(null, "a"));
	}
}
