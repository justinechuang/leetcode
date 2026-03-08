//799. Champagne Tower (Medium)
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for(int i=0; i<=query_row; i++){
            for(int j=0; j<=i; j++){
                if(dp[i][j] > 1){
                    double overflow = (dp[i][j] -1) /2.0;
                    dp[i+1][j+1] += overflow;
                    dp[i+1][j] += overflow;
                    dp[i][j] = 1; 
                }
            }
        }
        return dp[query_row][query_glass]; 
    }
}