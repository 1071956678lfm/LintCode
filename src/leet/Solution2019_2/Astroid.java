package leet.Solution2019_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Astroid {
    public int[] asteroidCollision(int[] asteroids) {
        // + right   - left
        //最终肯定为负的整齐在左侧,正的在右侧
        List<Integer> tmpList = new LinkedList<>();
        for (int num : asteroids)
            tmpList.add(num);
        int index = 0;
        while (index < tmpList.size()) {
            if (tmpList.size() <= 1 || index + 1 == tmpList.size())
                break;
            int pre = tmpList.get(index);
            int cur = tmpList.get(index + 1);
            if (pre < 0) {
                ++index;
            } else if (pre > 0 && cur < 0) { //collisions occur
                if (pre + cur == 0) {
                    tmpList.remove(index);
                    tmpList.remove(index);
                    if (index != 0)
                        --index;
                } else if (pre + cur < 0) {
                    tmpList.remove(index);
                    if (index != 0)
                        --index;
                } else {
                    tmpList.remove(index + 1);
                }
            } else {
                ++index;
            }
        }
        int[] ans = new int[tmpList.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = tmpList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Astroid().asteroidCollision(new int[]{1, 1, -1, -2})));
    }
}
