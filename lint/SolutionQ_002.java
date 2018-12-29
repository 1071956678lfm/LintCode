package Ë¢Ìâ;

public class Solution_Q002 {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public static long trailingZeros(long n) {
    	long result=0;
		long tmp;
    	
    	tmp=n;
    	while(tmp>=5) {
    		
    		result+=tmp/5;
    		tmp=tmp/5;
    	}
    	
        return result;
    }
}

class Test {

	public static void main(String[] args) {
		System.out.println(Solution_Q002.trailingZeros(125));

	}

}