package leet.Couples_holding_hands;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * N couples sit in 2N seats arranged in a row and want to hold hands.
     * We want to know the [minimum number of swaps] so that every couple is sitting side by side.
     * A swap consists of choosing any two people, then they stand up and switch seats.
     * <p>
     * The people and seats are represented by an integer from 0 to 2N-1,
     * the couples are numbered in order, the first couple being (0, 1),
     * the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
     * <p>
     * The couples' initial seating is given
     * by row[i] being the value of the person who is initially sitting in the i-th seat.
     * <p>
     * <p>
     * Input: row = [0, 2, 1, 3]
     * Output: 1
     * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
     */
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; ++i)
            map.put(row[i], i);
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int couple = getCouple(row[i]);
            if (row[i + 1] != couple) {//not couple
                int coupleIndex = map.get(couple);
                map.put(row[i + 1], coupleIndex);
                map.put(couple, i + 1);
                swap(row, i + 1, coupleIndex);
                count++;
            }
        }
        return count;
    }

    private int getCouple(int x) {
        return x % 2 == 0 ? x + 1 : x - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
