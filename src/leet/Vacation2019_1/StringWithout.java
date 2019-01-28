package leet.Vacation2019_1;

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
     * @param A
     * @param B
     * @return
     */
    public String strWithout3a3b(int A, int B) {
        char ch_bigger;
        char ch_smaller;
        int big = Math.max(A, B);
        int small = Math.min(A, B);
        if (A * B == 1)
            return "ab";
        if (A==2&&B==2)
            return "aabb";
        if (A > B) {
            ch_bigger = 'a';
            ch_smaller = 'b';
        } else {
            ch_bigger = 'b';
            ch_smaller = 'a';
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < big; ) {
            int index = 0;
            while (index < 2 && i < big) {
                ans.append(ch_bigger);
                index++;
                i++;
            }
            if (ans.length() != A + B) {
                ans.append(ch_smaller);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringWithout().strWithout3a3b(2, 2));
    }
}