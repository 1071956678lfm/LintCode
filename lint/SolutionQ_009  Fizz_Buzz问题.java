package À¢Ã‚;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	 /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public static List<String> fizzBuzz(int n) {
    	return Method_2(n);
    }

	private static List<String> Method_2(int n) {
		List<String> list=new ArrayList<String>();
    	for(int i=1;i<=n;i++) {
    		String result=(i%3==0)?((i%5==0)?("fizz buzz"):("fizz")):((i%5==0)?("buzz"):(Integer.toString(i)));
    		list.add(result);
    	}
    	
		return list;
	}

	/**
	 * @param n
	 * @return
	 */
	public static List<String> Method_1(int n) {
		List<String> list=new ArrayList<String>();
    	for(int i=1;i<=n;i++) {
    		if(i%3==0&&i%5!=0) {
    			list.add("fizz");}
    		else if(i%5==0&&i%3!=0) {
    			list.add("buzz");}
    		else if(i%15==0) {
    			list.add("fizz buzz");}
    		else
    			list.add(Integer.toString(i));
    	}
    	
		return list;
	}
}

class Test {
	public static void main(String[] args) {
		System.out.println(Solution.fizzBuzz(15));
	}
}
