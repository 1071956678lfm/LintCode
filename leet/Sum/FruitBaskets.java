package leet.Sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 904
 */
public class FruitBaskets {
    /**
     * In a row of trees, the i-th tree produces fruit with type tree[i].
     * <p>
     * You start at any tree of your choice, then repeatedly perform the following steps:
     * <p>
     * 1.Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
     * 2.Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
     * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1,
     * then step 2, then back to step 1, then step 2, and so on until you stop.
     * <p>
     * You have two baskets, and each basket can carry any quantity of fruit,
     * but you want each basket to only carry one type of fruit each.
     * <p>
     * What is the total amount of fruit you can collect with this procedure?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,1]
     * Output: 3
     * Explanation: We can collect [1,2,1].
     * Example 2:
     * <p>
     * Input: [0,1,2,2]
     * Output: 3
     * Explanation: We can collect [1,2,2].
     * If we started at the first tree, we would only collect [0, 1].
     * Example 3:
     * <p>
     * Input: [1,2,3,2,2]
     * Output: 4
     * Explanation: We can collect [2,3,2,2].
     * If we started at the first tree, we would only collect [1, 2].
     * Example 4:
     * <p>
     * Input: [3,3,3,1,2,1,1,2,3,3,4]
     * Output: 5
     * Explanation: We can collect [1,2,1,1,2].
     * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
     */
    public int totalFruit(int[] tree) {
        int maxQuantity = 0;
        Set<Integer> set = new HashSet<>();
        int indexA = 0;
        int indexB = 0;
        int lower = 0;
        int lowerVal = 0;
        int tmpZero = 0;
        for (int treeIndex = 0; treeIndex < tree.length; ++treeIndex) {
            if (tree[treeIndex] == 0) {
            } else if (set.isEmpty()) {
                indexA = treeIndex;
                lower = indexA;
                lowerVal = tree[treeIndex];
                set.add(tree[treeIndex]);
            } else if (!set.contains(tree[treeIndex])) {
                switch (set.size()) {
                    case 1:
                        indexB = treeIndex;
                        lower = indexB;
                        lowerVal = tree[treeIndex];
                        set.add(tree[treeIndex]);
                        break;
                    case 2:
                        maxQuantity = Math.max(maxQuantity, indexB - indexA + 1);
                        indexA = lower;
                        indexB = treeIndex;
                        lower = indexB;
                        set.clear();
                        set.add(tree[indexA]);
                        set.add(tree[indexB]);
                        break;
                    default:
                        break;
                }
            } else {
                ++indexB;
            }
        }
        return Math.max(maxQuantity, indexB - indexA + 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(new FruitBaskets().totalFruit(nums));
    }
}
