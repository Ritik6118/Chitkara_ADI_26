package DP;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs{
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new Integer[cost.length+2];
        int a=cost(cost,0);
        Arrays.fill(dp,null);
        int b=cost(cost,1);
        // System.out.println(a+" "+b);
        return Math.min(a,b);
    }
    public int cost(int [] cost,int i){
        if(dp[i]!=null){
            return dp[i];
        }
        if(i>=cost.length){
            return 0;
        }
        int a=cost(cost,i+1)+cost[i];
        int b=cost(cost,i+2)+cost[i];
        return dp[i]=Math.min(a,b);
    }
}