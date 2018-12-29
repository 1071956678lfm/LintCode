package Questions;

public class SolutionQ_004 {
    /*
     * Let the ordered ugly numbers be
     * arranged in the single array.
     * And we put three indexes into the array to show the three base array.
     * */
    public int nthUglyNumber(int n) {
        int[] resultArr = new int[n];
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        resultArr[0] = 1;
        for (int i = 1; i < n; i++) {
            resultArr[i] = Math.min((Math.min(resultArr[index_2] * 2, resultArr[index_3] * 3)), resultArr[index_5] * 5);
            if (resultArr[i] == resultArr[index_2] * 2)
                index_2++;
            if (resultArr[i] == resultArr[index_3] * 3)
                index_3++;
            if (resultArr[i] == resultArr[index_5] * 5)
                index_5++;
        }
        return resultArr[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new SolutionQ_004().nthUglyNumber(1665));
    }
}
