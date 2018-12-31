package leet.Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    /**
     * In a forest, each rabbit has some color.
     * Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them.
     * Those answers are placed in an array.
     * <p>
     * Return the minimum number of rabbits that could be in the forest.
     * <p>
     * <p>
     * <p>
     * Examples:
     * Input: answers = [1, 1, 2]
     * Output: 5
     * Explanation:
     * The two rabbits that answered "1" could both be the same color, say red.
     * The rabbit than answered "2" can't be red or the answers would be inconsistent.
     * Say the rabbit that answered "2" was blue.
     * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
     * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
     * <p>
     * Input: answers = [10, 10, 10]
     * Output: 11
     * <p>
     * Input: answers = []
     * Output: 0
     * <p>
     * Analyse:
     * Encounter 0 .add one
     * The same value means the same color
     * <p>
     * <p>
     * [1] -> 2
     * [1,1] -> 2
     * [1,1,1] -> 4
     * [1,1,1,1] -> 4
     * <p>
     * [2]->3
     * [2,2]-> 3
     * [2,2,2] -> 3
     * [2,2,2,2] -> 6
     * [2,2,2,2,2] -> 6
     * [2,2,2,2,2,2] -> 6
     * [2,2,2,2,2,2,2] -> 9
     * <p>
     * [3] -> 4
     * [3,3] -> 4
     * [3,3,3] -> 4
     * [3,3,3,3] -> 4
     * [3,3,3,3,3] -> 8
     */
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < answers.length; ++i)
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        result += map.getOrDefault(0, 0); //ad the zero value
        map.remove(0);
        for (int color : map.keySet()) {
            int base = color + 1;
            double otherSize = map.get(color);
            double num=Math.ceil(otherSize/base);
            result += num*base;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,3};
        System.out.println(new RabbitsInForest().numRabbits(nums));
    }
}
