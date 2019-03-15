package leet.Answer2019_3;

import java.util.Arrays;

//973
public class KClosetPoints {
    /**
     * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
     * <p>
     * (Here, the distance between two points on a plane is the Euclidean distance.)
     * <p>
     * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
     */
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        if (K == 0)
            return ans;
        Arrays.sort(points, (o1, o2) -> (int) (getDistance(o1) - getDistance(o2)));
        for (int i = 0; i < K; ++i) {
            ans[i] = points[i];
        }
        return ans;
    }

    private double getDistance(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3},
                {-2, 2},
        };
        System.out.println(Arrays.deepToString(new KClosetPoints().kClosest(nums, 1)));
    }
}
