package DP;
public class Decode_Ways{
    
    Integer[] dp=new Integer[200];
    public int numDecodings(String s) {
        return dec(s,0);
    }
    public int dec(String s,int i){
        if(dp[i]!=null){
            return dp[i];
        }
        if(i>=s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        int a=dec(s,i+1);
        if(i+1<s.length() && ((s.charAt(i)-'0')*10+s.charAt(i+1)-'0') <= 26){
            // System.out.println((s.charAt(i)-'0')*10+s.charAt(i+1)-'0');
            a+=dec(s,i+2);
        }
        dp[i]=a;
        return a;
    }
}