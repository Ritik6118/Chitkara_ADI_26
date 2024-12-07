package DP;
public class Min_Cost_for_Tickets {
    Integer[ ]dp;
    public int mincostTickets(int[] days, int[] costs) {
        int [] freq  =new int[366];
        dp=new Integer[366];
        for(int i:days){
            freq[i]++;
        } 
        return solve(freq,costs,1);
    }
    public int solve(int[] freq,int[] costs,int idx){
        if(idx>=freq.length){
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        if(freq[idx]==0){
            return solve(freq,costs,idx+1);
        }
        int a=costs[0]+solve(freq,costs,idx+1);
        int b=costs[1]+solve(freq,costs,idx+7);
        int c=costs[2]+solve(freq,costs,idx+30);
        return dp[idx]=Math.min(a,Math.min(b,c));
    }
}