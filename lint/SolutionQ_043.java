package Questions;

public class Solution {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public static int reverseInteger(int number) {
        int result = number % 10;
        number = number / 10;
        while (number > 0) {
            result *= 10;
            result += number % 10;
            number = number / 10;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Solution.reverseInteger(342));
    }
}