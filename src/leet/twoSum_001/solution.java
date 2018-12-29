package leet.twoSum_001;
import java.util.HashMap;

public class solution {

    public int[] twoSum(int[] nums, int target) {
        return solution_3(nums, target);
    }

    /**
     * 1.暴力求解
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

    /**
     * 2.两次迭代 首次迭代,把nums的内容和对应的指针形成映 第二次迭,直接在hash tab
     * e里寻找相应的内容即可(不可以是自己) 时间复杂度O(n),空间复杂度O(n)
     * 
     * 主要是减少了二次探查的时间复杂度,为O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int[] solution_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 3.基于2 我们可以只进行一轮迭�?? 边创建hash table 边进行look back
     * 
     * @param nums: 数组
     * @param target: 目标值大
     * @return
     */
    private int[] solution_3(int[] nums, int target) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashtable.keySet().contains(complement)) {
                int index = hashtable.get(complement);
                return new int[] { index, i };
            }
            hashtable.put(nums[i], i);
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
