package Graph;

import java.util.*;

public class Number_of_Provinces {
    HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public int findCircleNum(int[][] isConnected) {
        for(int i=0;i<isConnected.length;i++){
            map.put(i,new HashMap<>());
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    map.get(i).put(j,1);
                }
            }
        }
        // System.out.println(map);
        return component();
    }
    public int component() {
		int component=0;
		Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		
		for(int i:map.keySet()) {
			if(visited.contains(i)) {
				continue;
			}
			component++;
			q.add(i);
			while(!q.isEmpty()) {
				int n=q.poll();
				if(visited.contains(n)) {
					continue;
				}
				visited.add(n);
				for( int j:map.get(n).keySet()) {
					if(!visited.contains(j)) {
						q.add(j);						
					}
				}
			}
		}
		return component;
	}
}