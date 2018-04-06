package Questions;

public class SolutionQ_142 {
    /**
     * @param n: An integer
     * @return: True or false
     */
    public static boolean checkPowerOf2(int n) {
        if (n < 1)
            return false;
        if (n <= 2)
            return true;
        if (n % 2 != 0)
            return false;
        return checkPowerOf2(n / 2);
    }

    public static void main(String[] args) {

    }

}
