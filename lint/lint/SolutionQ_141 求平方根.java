package lint;

public class SolutionQ_141 {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long left = 0;
        long right = x / 2;
        while (left < right) {
            long mid = (left + right) / 2;
            long result = mid * mid;
            if (result == x)
                return (int) mid;
            else if (result > x) {
                right = (mid - 1);
            } else if (result < x) {
                left =  (mid + 1);
            }
        }
        long tmp = right * right;
        if (tmp > x)
            return (int) (right - 1);
        return (int) right;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionQ_141().sqrt(2147483647));
    }
}
