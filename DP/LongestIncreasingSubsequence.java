package DP;
public class LongestIncreasingSubsequence {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new Integer[nums.length][nums.length];
        return lis(nums,0,-1);
    }
    public int lis(int[] arr,int idx,int previdx){
        if(idx>=arr.length){
            return 0;
        }
        if(previdx!=-1 && dp[idx][previdx]!=null){
            return dp[idx][previdx];
        }
        int take=0;
        if(previdx==-1||arr[previdx]<arr[idx]){
            take=1+lis(arr,idx+1,idx);
        }
        int nottake=lis(arr,idx+1,previdx);
        if(previdx!=-1){
            return dp[idx][previdx]=Math.max(take,nottake);
        }
        return Math.max(take,nottake);
    }
}