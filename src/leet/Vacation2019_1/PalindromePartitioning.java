package leet.Vacation2019_1;

import java.util.ArrayList;
import java.util.List;

//131
public class PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p>
     * Return all possible palindrome partitioning of s.
     * <p>
     * Example:
     * <p>
     * Input: "aab"
     * Output:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     * <p>
     * DFS
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionDFSUtil(new ArrayList<>(), result, s);
        return result;
    }

    private void partitionDFSUtil(List<String> item,
                                  List<List<String>> ans,
                                  String partStr) {
        if (partStr.length() == 0) {
            ans.add(new ArrayList<>(item));
        }
        for (int i = 1; i <= partStr.length(); ++i) {
            String sub = partStr.substring(0, i);
            if (isPalindrome(sub)) {
                item.add(sub);
                partitionDFSUtil(item, ans, partStr.substring(i)); //check the rest
                item.remove(item.size() - 1);
            }
        }
    }

    boolean isPalindrome(String sample) {
        if (sample.length() == 0) return false;
        int left = 0;
        int right = sample.length() - 1;

        while (left < right) {
            if (sample.charAt(left) != sample.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("abccba"));
    }
}
