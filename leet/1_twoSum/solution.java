public class solution {

    public int[] twoSum(int[] nums, int target) {
        return solution_2(nums, target);
    }

    private int[] solution_2(int[] nums, int target) {
        return null;
    }

    /**
     * 1.暴力求解法
     */
    private int[] solution_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tmp)
                    return new int[] { i, j };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        solution s = new solution();
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] result = s.twoSum(nums, target);
        System.out.println(result);
    }
}
