package leet.Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * 77
 */
public class Combinations {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) return result;
        helper(n, k, new ArrayList<>(), 0, 0);
        return result;
    }

    private void helper(int n, int k, List<Integer> list, int index, int listSize) {
        if (listSize == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            list.add(i + 1);
            helper(n, k, list, i + 1, listSize + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }
}
