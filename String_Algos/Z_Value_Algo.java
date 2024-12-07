package String_Algos;

import java.util.Arrays;

public class Z_Value_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="LEVEL";
		String p="L";
		int[] z=z_fun(p,s);
		int c=0;
		System.out.println(Arrays.toString(z));
		for(int i=0;i<z.length;i++) {
			if(z[i]==p.length()) {
				c++;
				System.out.println(i-p.length()-1);
			}
		}
		System.out.println(c);
	}

	private static int[] z_fun(String p, String s) {
		// TODO Auto-generated method stub
		String st=p+"$"+s;
		int l=0;
		int r=0;
		int[]z=new int[st.length()];
		for(int i=1;i<st.length();i++) {
//			kick start
			if(i<=r) {
				z[i]=Math.min(z[i-l], r-i+1);
//				Math.max(prev kick start value, maximum known range)
			}
//			further calculation 
			while(i+z[i]<st.length() && st.charAt(z[i])==st.charAt(i+z[i])){
				z[i]++;
			}
//			setting bounds
			if(i+z[i]-1>r) {
				l=i;
				r=i+z[i]-1;
			}
		}
		return z;
	}
	

}
