package Graph;

import java.util.*;

public class Number_of_Enclaves {
    public int numEnclaves(int[][] arr) {
        boolean [][]visited=new boolean [arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==1 ){
                dfs(i,0,visited,arr);
            }
            if(arr[i][arr[0].length-1]==1){
                dfs(i,arr[0].length-1,visited,arr);
            }
        }
        for(int i=0;i<arr[0].length;i++){
            if(arr[0][i]==1 ){
                dfs(0,i,visited,arr);
            }
            if(arr[arr.length-1][i]==1 ){
                dfs(arr.length-1,i,visited,arr);
            }
        }
        int c=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1 && visited[i][j]==false){
                    c++;
                }
            }
        }
        return c;
    }
    int [] r={0,0,1,-1};
    int [] c={1,-1,0,0};
    public void dfs(int cr, int cc, boolean [][] visited,int [][] arr){
        Stack<pair> st=new Stack<pair>();
        st.push(new pair(cr,cc));
        visited[cr][cc]=true;
        while(!st.isEmpty()){
            pair p=st.pop();
            for(int i=0;i<4;i++){
                int nr=p.r+r[i];
                int nc=p.c+c[i];
                if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && !visited[nr][nc] && arr[nr][nc]==1){
                    visited[nr][nc]=true;
                    st.push(new pair(nr,nc));
                }
            }
        }
    }
}
//class pair{
//    int r;
//    int c;
//    pair(int r,int c){
//        this.r=r;
//        this.c=c;
//    }
//}