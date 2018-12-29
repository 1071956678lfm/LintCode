package lint;

public class Solution_Q111 {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int result = 1;
        int next = 1;
        for (int i = 0; i < n; i++) {
            next = result + next;
            result = next;
        }
        return result;
    }
}