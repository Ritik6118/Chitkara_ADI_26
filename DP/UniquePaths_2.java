package DP;
public class UniquePaths_2 {
    public int uniquePathsWithObstacles(int[][] arr) {
        int c=paths(arr,0,0);
        return c;
    }
    Integer[][] dp=new Integer[101][101];
    public int paths(int[][] arr,int r,int c){
        if(dp[r][c]!=null){
            return dp[r][c];
        }
        if(r>=arr.length||c>=arr[0].length){
            return 0;
        }
        if(arr[r][c]==1){
            return 0;
        }
        if(r==arr.length-1 && c==arr[0].length-1){
            return 1;
        }
        int v=paths(arr,r+1,c);
        int h=paths(arr,r,c+1);
        return dp[r][c]=v+h;
    }
}