package leet.Answer2019_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//216
public class CombinationSum {
    /**
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * <p>
     * Note:
     * <p>
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Example 2:
     * <p>
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, new LinkedList<>(), k, n, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> es, int k, int n, int begin) {
        if (k == 0) {
            if (n == 0)
                ans.add(new ArrayList<>(es));
            return;
        }
        for (int i = begin; i <= 9 && i <= n; ++i) {
            es.add(i);
            dfs(ans, es, k - 1, n - i, i + 1);
            es.removeLast();
        }
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> list,
                     int k, int n,
                     int sum, int counter, int begin) {
        if (counter == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = begin; i <= 9; ++i) {
            list.add(i);
            dfs(ans, list, k, n, sum + i, counter + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum3(3, 7));
    }
}
