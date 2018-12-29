package lint;

import java.util.HashMap;
import java.util.Iterator;

public class SolutionQ_101 {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(nums.length);
        System.out.println(new SolutionQ_101().removeDuplicates(nums));
        System.out.println(nums.length);
    }
}
