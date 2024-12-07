package Graph;

import java.util.*;

public class Rotting_Oranges {
    public int orangesRotting(int[][] arr) {
        boolean [][] visited=new boolean [arr.length][arr[0].length];
        int [][] time= new int [arr.length][arr[0].length];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                    q.add(new pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int [] r={0,0,1,-1};
        int [] c={-1,1,0,0};
        while(!q.isEmpty()){
            pair p=q.poll();
            time [p.r][p.c]=p.t;
            for(int i=0;i<4;i++){
                int nr=p.r+r[i];
                int nc=p.c+c[i];
                int nt=p.t+1;
                if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && 
                visited[nr][nc]==false && arr[nr][nc]!=0 ){
                    q.add(new pair(nr,nc,nt));
                    visited[nr][nc]=true;
                 }
            }

        }
            int t=0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    if(arr[i][j]!=0 && visited[i][j]==false){
                        return -1;
                    } 
                    t=Math.max(t,time [i][j]);
                }
            }
            return t;
    }
    class pair{
    	int r;
    	int c;
    	int t;
    	pair(int r,int c,int t){
    		this.r=r;
    		this.c=c;
    		this.t=t;
    	}
    }
}