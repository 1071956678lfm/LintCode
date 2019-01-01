package leet.Sum;

import java.util.Stack;

/**
 * 503
 */
public class NextGreaterElement {
    /**
     * Given a circular array (the next element of the last element is the first element of the array)
     * , print the Next Greater Number for every element.
     * The Next Greater Number of a number x is the first greater number to its traversing-order next
     * in the array, which means you could search circularly to find its next greater number.
     * If it doesn't exist, output -1 for this number.
     * <p>
     * Example 1:
     * Input: [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number;
     * The second 1's next greater number needs to search circularly, which is also 2.
     * <p>
     * Analyse:
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); //store the index
        //The stack will store index, and the top nums[index] is the smallest

        for (int index = nums.length * 2 - 1; index >= 0; --index) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index % nums.length])
                stack.pop();
            result[index % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(index % nums.length);
        }

        return result;
    }

    public static void main(String[] args) {
        // [120,11,120,120,123,123,-1,100,100,100]
        int[] nums = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        new NextGreaterElement().nextGreaterElements(nums);
    }
}
