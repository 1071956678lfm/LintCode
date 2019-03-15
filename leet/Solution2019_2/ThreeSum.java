package leet.Solution2019_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//923
public class ThreeSum {
    /**
     * Given an integer array A, and an integer target,
     * return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
     * <p>
     * As the answer can be very large, return it modulo 10^9 + 7.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
     * Output: 20
     * Explanation:
     * Enumerating by the values (A[i], A[j], A[k]):
     * (1, 2, 5) occurs 8 times;
     * (1, 3, 4) occurs 8 times;
     * (2, 2, 4) occurs 2 times;
     * (2, 3, 3) occurs 2 times.
     * Example 2:
     * <p>
     * Input: A = [1,1,2,2,2,2], target = 5
     * Output: 12
     * Explanation:
     * A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
     * We choose one 1 from [1,1] in 2 ways, - > C (2,1)
     * and two 2s from [2,2,2,2] in 6 ways.  - > C (4,2)
     * <p>
     * Analyse: 分类讨论
     * A[i] A[j] A[k]
     * 1. A[i]< A[j] < A[k]
     * 2. A[i]=A[j] < A[k]
     * 3. A[i] < A[j] = A[k]
     * 4. A[i] = A[j] = A[k]
     */
    public int threeSumMulti(int[] A, int target) {
        long ans = 0;
        long module = (long) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();//num - > occur times.
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //case 4
        if (target % 3 == 0) {
            //plus C(n,3)
            long val = map.getOrDefault(target / 3, 0);
            if (val != 0)
                ans += val * (val - 1) * (val - 2) / 6;
        }
        //case 2 3
        for (int key : map.keySet()) {
            int rest = target - key;
            if (rest % 2 == 0 && rest / 2 != key) {
                int T = map.getOrDefault(rest / 2, 0);
                int a = map.get(key);
                ans += a * (T * (T - 1) / 2);
            }
        }
        //case 1
        LinkedList<Integer> linkedList = new LinkedList<>(map.keySet());
        int[] plainArr = new int[linkedList.size()]; //单个扁平数组
        for (int i = 0; i < plainArr.length; ++i)
            plainArr[i] = linkedList.get(i);
        int tmpAns = 0;
        for (int i = 0; i < plainArr.length; ++i) {
            for (int j = i + 1; j < plainArr.length; ++j) {
                int T = target - plainArr[i] - plainArr[j]; //C = target - a - b
                if (T >= 0 && T != plainArr[i] && T != plainArr[j] &&
                        map.keySet().contains(T))
                    tmpAns += map.get(T) * map.get(plainArr[i]) * map.get(plainArr[j]);
            }
        }

        //get two sum
        return (int) ((ans + tmpAns / 3) % module);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\JAVA文件\\lintCode\\LintCode\\src\\leet\\Solution2019_2\\testcase.txt")));
        String l1 = br.readLine();
        String l2 = br.readLine();
        String[] strings = l1.split("[,]");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; ++i)
            nums[i] = Integer.parseInt(strings[i]);
        int target = Integer.parseInt(l2);
        long x = 3000;
        long val = x * (x - 1) * (x - 2) / 6;
        long module = (long) (Math.pow(10, 9) + 7);
        long ans = val % module;
        System.out.println(new ThreeSum().threeSumMulti(nums, target));
    }
}
