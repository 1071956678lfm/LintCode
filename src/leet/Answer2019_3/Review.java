package leet.Answer2019_3;

public class Review {
    public int f(int m, int n){
        int[][] grids = new int[m][n];
        grids[0][0] = 0;
        for (int i = 1; i < n ; ++i){
            grids[0][i] = grids[0][i-1] +1;
        }

        for(int i=1; i< m;++i){
            grids[i][0]=grids[i-1][0] +1;
        }

        for (int i =1 ; i  < m ; ++i){
            for (int j = 1; j< n;++j){
                grids[i][j] = grids[i-1][j] + grids[i][j-1];
            }
        }

        return grids[m-1][n-1];

    }
    public static void main(String[] args) {
        System.out.println(new Review().f(2,2));

    }
}
