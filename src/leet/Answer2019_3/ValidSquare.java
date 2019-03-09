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
        int[] xAxis = {p1[0], p2[0], p3[0], p4[0]};
        int[] yAxis = {p1[1], p2[1], p3[1], p4[1]};
        Arrays.sort(xAxis);
        Arrays.sort(yAxis);
        return (xAxis[0] + xAxis[3] == xAxis[1] + xAxis[2]) &&
                (yAxis[0] + yAxis[3] == yAxis[1] + yAxis[2]);
    }

    public static void main(String[] args){

    }
}
