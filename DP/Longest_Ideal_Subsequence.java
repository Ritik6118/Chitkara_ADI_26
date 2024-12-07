package DP;
public class Longest_Ideal_Subsequence{
    Integer[][] dp;
    public int longestIdealString(String s, int k) {
        dp=new Integer[s.length()][130];
        return f(s,k,0,'#');
    }
    public int f(String s, int k, int si, char prevChar){
        if(si>=s.length()){
            return 0;     
        } 
        if(dp[si][prevChar]!=null){
            return dp[si][prevChar];
        }
        int take=0;
        if(Math.abs(prevChar-s.charAt(si))<=k || prevChar=='#'){
            take = 1 + f(s,k,si+1,s.charAt(si));
        }
        int notTake = f(s,k,si+1,prevChar);
        return dp[si][prevChar] = Math.max(take,notTake);
    }
}