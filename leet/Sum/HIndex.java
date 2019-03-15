package leet.Sum;

import java.util.Arrays;

/**
 * 274
 */
public class HIndex {
    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher,
     * write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia:
     * "A scientist has index h
     * if h of his/her N papers have at least h citations each,
     * and the other N − h papers have no more than h citations each."
     * <p>
     * Example:
     * <p>
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
     * received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining
     * two with no more than 3 citations each, her h-index is 3.
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int begin = citations.length - 1;
        int h = 0;
        while (begin >= 0 && citations[begin] >= citations.length - begin) {
            h = citations.length - begin;
            --begin;
        }
        return h;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(new HIndex().hIndex(nums));
    }
}
