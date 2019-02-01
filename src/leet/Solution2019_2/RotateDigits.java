package leet.Solution2019_2;

//788
public class RotateDigits {
    /**
     * X is a good number if after rotating each digit individually by 180 degrees,
     * we get a valid number that is different from X.
     * Each digit must be rotated - we cannot choose to leave it alone.
     * <p>
     * A number is valid if each digit remains a digit after rotation.
     * 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
     * and the rest of the numbers do not rotate to any other number and become invalid.
     * <p>
     * Now given a positive number N, how many numbers X from 1 to N are good?
     * <p>
     * Example:
     * Input: 10
     * Output: 4
     * Explanation:
     * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
     * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
     * <p>
     * 2 - > 5
     * 5 -> 2
     * 6 -> 9
     * 1 0 8
     * <p>
     * 3 4 7
     */
    public int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 2; i <= N; ++i) {
            if (judge(i))
                ++ans;
        }
        return ans;
    }

    private boolean judge(int N) {
        String s = String.valueOf(N);
        boolean flage = false;
        for (char ch : s.toCharArray()) {
            if (ch == '3' || ch == '4' || ch == '7')
                return false;
            else if (ch == '2' || ch == '5' || ch == '6' || ch == '9') {
                flage = true;
            }
        }
        return flage;
    }

    public static void main(String[] args) {
        System.out.println(new RotateDigits().judge(2));
        System.out.println(new RotateDigits().rotatedDigits(10));
    }
}
