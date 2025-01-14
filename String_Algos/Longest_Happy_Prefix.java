package String_Algos;

public class Longest_Happy_Prefix {
	public String longestPrefix(String s) {
        int [] lps=new int[s.length()];
        int len=0;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return s.substring(s.length()-lps[lps.length-1],s.length());
    }
}
