package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_islands{
    
    public int numIslands(char[][] grid) {
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(i,j,grid,visited);
                    c++;
                }
            }
        }
        return c;
    }
    int [] rr={0,0,1,-1};
    int [] cc={1,-1,0,0};
    public void bfs(int r,int c,char[][] arr,boolean [][] visited){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(r,c));
        visited[r][c]=true;
        while(!q.isEmpty()){
            pair p=q.poll();
            for(int i=0;i<4;i++){
               int nr=p.r+rr[i];
               int nc=p.c+cc[i];
               if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && !visited[nr][nc] && arr[nr][nc]=='1'){
                    q.add(new pair(nr,nc));
                    visited[nr][nc]=true;
               } 
            }
        }
    }
}
class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}