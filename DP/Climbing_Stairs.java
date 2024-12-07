package DP;
public class Climbing_Stairs{
    Integer [] dp=new Integer[46];
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        if(n==0){
            return 1;
        }
        int a=climbStairs(n-1);
        int b=climbStairs(n-2);
        
        return dp[n]=a+b;
    }
}