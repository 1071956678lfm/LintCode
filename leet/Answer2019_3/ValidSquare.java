package leet.Answer2019_3;

import java.util.Arrays;

//593
public class ValidSquare {
    /**
     * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
     * <p>
     * The coordinate (x,y) of a point is represented by an integer array with two integers.
     * <p>
     * Example:
     * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     * Output: True
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Arrays.sort(points, (o1, o2) -> {
            int result = o1[0] - o2[0];
            if (result != 0)
                return result;
            else
                return o1[1] - o2[1];
        });

        double lenA = getDistance(points[0], points[1]);
        double lenB = getDistance(points[0], points[2]);
        double t = getDistance(points[0], points[3]);
        return lenA != 0 && lenA == lenB && t == (Math.pow(lenA, 2) + Math.pow(lenB, 2));
    }

    private double getDistance(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }

    public static void main(String[] args) {
        System.out.println(new ValidSquare().validSquare(new int[]{0, 0},
                new int[]{1, 1},
                new int[]{1, 0},
                new int[]{0, 1}));
    }
}
