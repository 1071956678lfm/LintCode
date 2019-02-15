package leet.Solution2019_2;

import java.util.Arrays;

//473
public class _Matchsticks {
    /**
     * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
     * please find out a way you can make one square by using up all those matchsticks.
     * You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
     * <p>
     * Your input will be several matchsticks the girl has, represented with their stick length.
     * Your output will either be true or false,
     * to represent whether you could make one square using all the matchsticks the little match girl has.
     * <p>
     * Example 1:
     * Input: [1,1,2,2,2]
     * Output: true
     * <p>
     * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
     * Example 2:
     * Input: [3,3,3,3,4]
     * Output: false
     * <p>
     * Explanation: You cannot find a way to form a square with all the matchsticks.
     */
    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0)
            return false;
        int target = sum / 4;

        return true;
    }
}
