package String_Algos;

public class KMP_algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aabaacaabaad";
		String pattern ="aab";
		kmp(s,pattern);
	}

	private static void kmp(String s, String pattern) {
		// TODO Auto-generated method stub
		int [] lps=lps(pattern+"#"+s);
		int c=0;
		for(int i=0;i<lps.length;i++) {
			if(lps[i]==pattern.length()) {
				c++;
				System.out.println(i-2*pattern.length());
			}
		}
		System.out.println("count =" +c);
	}

	private static int[] lps(String s) {
		// TODO Auto-generated method stub
		int[] lps=new int[s.length()];
		int len=0;
		int i=1;
		while(i<s.length()) {
			if(s.charAt(i)==s.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}
			else {
				if(len>0) {
					len=lps[len-1];
				}
				else {
					lps[i]=0;
					i++;
				}
			}
		}
		return lps;
	}

}
