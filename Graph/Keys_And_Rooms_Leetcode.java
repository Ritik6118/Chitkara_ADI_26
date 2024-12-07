package Graph;

import java.util.*;

public class Keys_And_Rooms_Leetcode {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        for(int i=0;i<rooms.size();i++){
            map.put(i,new HashMap<>());
            for(int j:rooms.get(i)){
                map.get(i).put(j,1);
            }
        }
        return bfs();
    }
    public boolean bfs(){
        Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> visited =new HashSet<>();
		q.add(0);
		while(!q.isEmpty()) {
			int n=q.poll();
			if(visited.contains(n)) {
				continue;
			}
			visited.add(n);
			// if(n==des) {
			// 	return true;
			// }
			for(int i:map.get(n).keySet()) {
				if(!visited.contains(i)) {
					q.add(i);
				}
			}
            
		}
        return visited.size()==map.size();
    }
}