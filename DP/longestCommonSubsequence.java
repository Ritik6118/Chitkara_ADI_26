package DP;
public class longestCommonSubsequence {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new Integer[text1.length()][text2.length()];
        return lcs(text1,text2,0,0);
    }
    public int lcs(String s1,String s2,int i,int j){
        if(i>=s1.length()||j>=s2.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int match=0;
        int not_match=0;
        if(s1.charAt(i)==s2.charAt(j)){
            match=1+lcs(s1,s2,i+1,j+1);
        }
        else{
            not_match=0+Math.max(lcs(s1,s2,i+1,j),lcs(s1,s2,i,j+1));
        }
        dp[i][j]=Math.max(match,not_match);
        return Math.max(match,not_match);

    }
}