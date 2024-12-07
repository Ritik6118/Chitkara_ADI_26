package DP;
public class Number_of_dice_rolls {
    Integer[][] dp;
    int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new Integer[n+1][target+1];
        return solve(n,k,target);
    }
    public int solve(int n,int k,int target){
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        if(target==0 && n==0){
            return 1;
        }
        long a=0;
        for(int i=1;i<=k;i++){
            if(target-i>=0 && n-1>=0){
                a+=solve(n-1,k,target-i);
            }
        }
        dp[n][target]=(int)(a%mod);
        return (int)(a%mod);
    }
}