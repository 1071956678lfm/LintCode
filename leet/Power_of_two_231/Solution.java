package leet.Power_of_two_231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        return ((n & (n - 1)) == 0);
    }

}