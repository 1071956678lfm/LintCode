package leet.Vacation2019_1;

//984
public class StringWithout {
    /**
     * Given two integers A and B, return any string S such that:
     * <p>
     * S has length A + B and contains exactly A 'a' letters, and exactly B 'b'
     * letters; The substring 'aaa' does not occur in S; The substring 'bbb' does
     * not occur in S.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: A = 1, B = 2 Output: "abb" Explanation: "abb", "bab" and "bba" are all
     * correct answers. Example 2:
     * <p>
     * Input: A = 4, B = 1 Output: "aabaa"
     * <p>
     * <p>
     * A B [1,1] -> ab ba A B [1,2] -> abb bab bba A B [1,3] -> aa a
     *
     * @param A:Number of 'a'
     * @param B:Number of 'b'
     * @return
     */
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        String maxCh = A > B ? "a" : "b";
        String minCh = A > B ? "b" : "a";
        String sub = maxCh + maxCh + minCh;
        A = max;
        B = min;
        while (Math.abs(A - B) >= 2 && B > 0) {
            ans.append(sub);
            A -= 2;
            B -= 1;
        }
        while (A > 0 && B > 0) {
            ans.append("ab");
            --A;
            --B;
        }
        while (A > 0) {
            ans.append(maxCh.charAt(0));
            --A;
        }
        while (B > 0) {
            ans.append(minCh.charAt(0));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringWithout().strWithout3a3b(4, 1));
    }
}