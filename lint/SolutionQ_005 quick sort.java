package Questions;

import java.util.Arrays;

public class SolutionQ_005 {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return QuickSelect(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private int QuickSelect(int[] nums, int k, int left, int right) {
        if (right - left > 5) {
            int i = 0;
            int j = right - 1;
            for (; ; ) {
                int pivot = medianThree(nums, left, right);
                while (nums[++i] < pivot) {
                }
                while (nums[--j] > pivot) {
                }
                if (i < j)
                    swap(nums, i, j);
                else
                    break;
            }
            if (k <= i)
                return QuickSelect(nums, k, left, i - 1);
            else
                return QuickSelect(nums, k, i + 1, right);
        } else {
            Arrays.sort(nums);
            return nums[k - 1];
        }
    }

    private int medianThree(int[] nums, int left, int right) {
        int center = (left + right) / 2;
        if (nums[center] > nums[right]) {
            swap(nums, center, right);
        }
        if (nums[left] > nums[center]) {
            swap(nums, left, center);
        }
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }
        swap(nums, center, right - 1);
        return nums[right - 1];
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        SolutionQ_005 solutionQ_005 = new SolutionQ_005();
        System.out.println(solutionQ_005.kthLargestElement(1, new int[]{9, 3, 2, 4, 8}));
    }
}
