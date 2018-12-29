package Ë¢Ìâ;

public class SolutionQ_053 {
	/*
	 * @param s: A string
	 * 
	 * @return: A string
	 */
	public static String reverseWords(String s) {
		String tmp = s.trim();
		String[] words = tmp.split(" {1,}");
		StringBuilder result = new StringBuilder();
		for(int i=words.length-1;i>=0;i--) {
			result.append(words[i]);
			if(i!=0)
				result.append(" ");
		}

		return result.toString();
	}
}

class Test_053 {
	public static void main(String[] args) {
		System.out.println(SolutionQ_053.reverseWords("java adsaxsa    assxaaxs"));
	}
}