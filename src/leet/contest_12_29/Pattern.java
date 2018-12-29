package leet.contest_12_29;

import java.util.Stack;

public class Pattern {
    /**
     * Given a sequence of n integers a1, a2, ..., an,
     * a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
     * Design an algorithm that takes a list of n numbers as input
     * and checks whether there is a 132 pattern in the list.
     * <p>
     * Note: n will be less than 15,000.
     * <p>
     * Input: [1, 2, 3, 4]
     * <p>
     * Output: False
     * <p>
     * Explanation: There is no 132 pattern in the sequence.
     * <p>
     * <p>
     * 思路是我们维护一个栈和一个变量third，其中third就是第三个数字，也是pattern 132中的2
     * 栈里面按顺序放所有[大于]third的数字，也是pattern 132中的3
     * 那么我们在遍历的时候，如果当前数字小于third，即pattern 132中的1找到了，我们直接返回true即可
     * 因为已经找到了，注意我们应该从后往前遍历数组。
     * 如果当前数字大于栈顶元素，那么我们按顺序将栈顶数字取出，赋值给third，然后将该数字压入栈
     * 这样保证了栈里的元素仍然都是大于third的，我们想要的顺序依旧存在
     * 进一步来说，栈里存放的都是可以维持second > third的second值，其中的任何一个值都是大于当前的third值
     * 如果有更大的值进来，那就等于形成了一个更优的second > third的这样一个组合，并且这时弹出的third值比以前的third值更大，
     * 为什么要保证third值更大，因为这样才可以更容易的满足当前的值first比third值小这个条件
     */
    public boolean find132pattern(int[] nums) {
        /*
         * use one stack
         * */
        if (nums == null) return false;
        int n = nums.length;
        if (n < 3) return false;

        Stack<Integer> s = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) { //从后向前进行查找
            if (nums[i] < third) return true;
            while (!s.isEmpty() && nums[i] > s.peek()) {//准备压栈的数为num[i]
                //先把小于knum的全部出栈,knum保存出栈元素中的最小者
                third = s.pop();
            }
            s.add(nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 1, -4, -3};
        boolean result = new Pattern().find132pattern(nums);
        System.out.println(result);
    }
}
