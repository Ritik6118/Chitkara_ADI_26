package DP;
public class Unique_Paths {
    Integer[][] dp=new Integer[101][101];
    public int uniquePaths(int m, int n) {
        if(dp[m][n]!=null){
            return dp[m][n];
        }
        if(m<=0||n<=0){
            return 0;
        }
        if(m==1 && n==1){
            return 1;
        }
        int v=uniquePaths(m-1,n);
        int h=uniquePaths(m,n-1);
        return dp[m][n]=v+h;
    }
}