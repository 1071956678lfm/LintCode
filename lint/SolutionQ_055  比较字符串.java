package À¢Ã‚;


public class SolutionQ_055{
	  /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
    	return Method_1(A, B);
		
    }

	/**
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean Method_1(String A, String B) {
		if(B==null||B.isEmpty())
    		return true;
    	if(A.length()<B.length())
    		return false;
    	StringBuilder strA=new StringBuilder(A);
    	StringBuilder strB=new StringBuilder(B);
    	
    	CharSequence tmp=strB.subSequence(0, 1);
    	if(A.contains(tmp)) {
    		strB.deleteCharAt(0);
    		strA.deleteCharAt(A.indexOf(tmp.toString()));
    		return Method_1(strA.toString(), strB.toString());
    	}
    	
		return false;
	}
}

class Test_053 {
	public static void main(String[] args) {
		System.out.println(SolutionQ_055.compareStrings("BAV", "ABV"));
	}
}