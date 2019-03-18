import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T {
    public int bitwiseComplement(int N) {
        if (N == 0)
            return 1;
        long sum = com(N);
        return (int) (sum - N - 1);
    }

    private long com(int N) {
        long ans = 1;
        while (ans <= N) {
            ans = ans << 1;
        }
        return ans;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        Map<Integer, Integer> times = new HashMap<>();
        Arrays.fill(mod, 0);
        for (int aTime : time) {
            mod[aTime % 60]++;
            times.put(aTime, times.getOrDefault(aTime, 0) + 1);
        }
        int ans = 0;
        for (int aTime : time) {
            int m = aTime % 60;
            ans += mod[60 - (m == 0 ? 60 : m)];
            if (m == 0 || m == 30)
                --ans;
        }
        return ans / 2;
    }

    public int shipWithinDays(int[] weights, int D) {
        if (D == 1) {
            return sum(weights, 0, weights.length - 1);
        } else if (D == weights.length) {
            int ans = weights[0];
            for (int w : weights) {
                ans = ans < w ? w : ans;
            }
            return ans;
        }
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; ++i) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left < right) {
            int mid = (right + left) / 2;
            if (canSplit(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int m, int sum) {
        int cnt = 1, curSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            curSum += nums[i];
            if (curSum > sum) {
                curSum = nums[i];
                ++cnt;
                if (cnt > m)
                    return false;
            }
        }
        return true;
    }

    private int sum(int[] w, int begin, int end) {
        int ans = 0;
        for (int i = begin; i <= end; ++i) {
            ans += w[i];
        }
        return ans;
    }

    /**
     * 0 - 9  0
     * 10 - 99 --- 11 , 22 , ... 99
     * 100 - 999 --- 11* , 1*1 , 22* , 2*2 ,..., 9*9 , 99*
     * <p>
     * 1000 - 100* (1000 - 1009) ,
     */
    public int numDupDigitsAtMostN(int N) {
        return N - comple(N);
    }

    /**
     * 补集，每一位都不一样
     */
    private int comple(int n) {
        int ans = 0;
        int pow = powTen(n);
        ans += single(pow - 1);
        return ans;
    }

    private int single(int pow) {
        int ans = 0;
        for (int i = 1; i <= pow; ++i) {
            int tmp = tmp(i - 1);
            ans += 9 * tmp;
        }
        return ans;
    }

    private int tmp(int n) {
        int ans = 1;
        int factor = 9;
        for (int i = 0; i < n; ++i) {
            ans *= factor;
            --factor;
        }
        return ans;
    }

    private int powTen(int N) {
        int ans = 0;
        while (N > 0) {
            ++ans;
            N /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {660, 60, 60};
        System.out.println(new T().comple(1000));
    }
}