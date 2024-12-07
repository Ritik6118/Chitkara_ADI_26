package Graph;
import java.util.*;

public class Graph {
	
	HashMap<Integer,HashMap<Integer,Integer>> map;
	Graph(int v){
		map=new HashMap<>();
		
		for(int i=1;i<=v;i++) {
			map.put(i,new HashMap<>());
		}
	}
	public void dijkstra() {
		PriorityQueue<dijkstrapair> pq=new PriorityQueue<>(new Comparator<dijkstrapair>() {
			@Override
			public int compare(dijkstrapair p1,dijkstrapair p2) {
				return p1.cost-p2.cost;
			}
		});
		pq.add(new dijkstrapair(1,"",0));
		HashSet<Integer> visited=new HashSet<>();
		
		while(!pq.isEmpty()) {
			dijkstrapair pair=pq.poll();
			if(visited.contains(pair.vtx)) {
				continue;
			}
			visited.add(pair.vtx);
			System.out.println(pair);
			for(int i: map.get(pair.vtx).keySet()) {
				if(!visited.contains(i)) {
					dijkstrapair ndp=new dijkstrapair(i,pair.path+""+pair.vtx,pair.cost+map.get(pair.vtx).get(i));
					pq.add(ndp);
				}
			}
		}
	}
	public void prims() {
		PriorityQueue<primspair> pq=new PriorityQueue<>(new Comparator<primspair>() {
			@Override
			public int compare(primspair p1,primspair p2) {
				return p1.cost-p2.cost;
			}
		});
		pq.add(new primspair(1,1,0));
		HashSet<Integer> visited=new HashSet<>();
		
		while(!pq.isEmpty()) {
			primspair pair=pq.poll();
			if(visited.contains(pair.vtx)) {
				continue;
			}
			visited.add(pair.vtx);
			System.out.println(pair);
			for(int i: map.get(pair.vtx).keySet()) {
				if(!visited.contains(i)) {
					pq.add(new primspair(i,pair.vtx,map.get(pair.vtx).get(i)));
				}
			}
		}
	}
	public void addVertex(int v) {
		map.put(v, new HashMap<>());
	}
	public void addEdge(int v1,int v2,int weight) {
		map.get(v1).put(v2,weight);
		map.get(v2).put(v1,weight);
		
	}
	public boolean containsEdge(int v1,int v2) {
		return map.get(v1).containsKey(v2);
	}
	public boolean containsVertex(int v) {
		return map.containsKey(v);
	}
	public int no_of_edges() {
		int sum=0;
		for(int i:map.keySet()) {
			sum+=map.get(i).size();
		}
		return sum/2;
	}
	public void removeEdge(int v1,int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}
	public void removeVertex(int v) {
		for(int i:map.get(v).keySet()) {
			map.get(i).remove(v);
		}
		map.remove(v);
	}
	public void display() {
		for(int i:map.keySet()) {
			System.out.println(i+"-->"+map.get(i));
		}
	}
	public boolean hasPath(int src,int des,HashSet<Integer> visited) {
		if(src==des) {
			return true;
		}
		visited.add(src);
		for(int i:map.get(src).keySet()) {
			if(!visited.contains(i)) {
				boolean ans=hasPath(i,des,visited);
				if(ans==true) {
					return true;
				}
			}
		}
		visited.remove(src);
		return false;
	}
	public void printAll_paths(int src,int des,HashSet<Integer> visited, String ans) {
		if(src==des) {
			System.out.println(ans + src);
			return;
		}
		visited.add(src);
		for(int i:map.get(src).keySet()) {
			if(!visited.contains(i)) {
				printAll_paths(i,des,visited,ans+src+" ");				
			}
		}
		visited.remove(src);
	}
	public boolean bfs (int src,int des) {
		Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> visited =new HashSet<>();
		q.add(src);
		while(!q.isEmpty()) {
			int n=q.poll();
			if(visited.contains(n)) {
				continue;
			}
			visited.add(n);
			if(n==des) {
				return true;
			}
			for(int i:map.get(n).keySet()) {
				if(!visited.contains(i)) {
					q.add(i);
				}
			}
		}
		return false;
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
	public boolean isCyclic() {
		int cycle=0;
		Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		
		for(int i:map.keySet()) {
			if(visited.contains(i)) {
				continue;
			}
			q.add(i);
			while(!q.isEmpty()) {
				System.out.println(visited + " "+q);
				int n=q.poll();
				if(visited.contains(n)) {
					cycle++;
					System.out.println(n);
//					return true;
				}
				visited.add(n);
				for( int j:map.get(n).keySet()) {
					if(!visited.contains(j)) {
						q.add(j);						
					}
				}
			}
		}
//		System.out.println(cycle);
		return cycle>=1;
	}
//	public boolean bfs(int src,int des) {
//		Queue<Integer> q=new LinkedList<>();
//		HashSet<Integer> visited=new HashSet<>();
//		q.add(src);
//		while(!q.isEmpty()) {
//			int n=q.poll();
//			if(visited.contains(n)) {
//				continue;
//			}
//			visited.add(n);
//			if(n==des) {
//				return true;
//			}
//			for(int i:map.get(n).keySet()) {
//				if(!visited.contains(i)) {
//					q.add(i);
//				}
//			}
//		}
//		return false;
//	}
	public boolean dfs(int src,int des) {
		Stack<Integer> st=new Stack<>();
		HashSet<Integer> visited=new HashSet<>();
		st.push(src);
		while(!st.isEmpty()) {
			int n=st.pop();
			if(visited.contains(n)) {
				continue;
			}
			visited.add(n);
			if(n==des) {
				return true;
			}
			for(int i:map.get(n).keySet()) {
				if(!visited.contains(i)) {
					st.push(i);
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	Graph(int v){
//		map=new HashMap<>();
//		for(int i=1;i<=v;i++) {
//			map.put(i, new HashMap<>());
//		}
//	}
//	public void addEdge(int v1,int v2,int weight) {
//		map.get(v1).put(v2, weight);
//		map.get(v2).put(v1, weight);
//	}
//	public boolean containsEdge(int v1,int v2) {
//		return map.get(v1).containsKey(v2);
//	}
//	public boolean containsVertex(int v) {
//		return map.containsKey(v);
//	}
//	public int number_of_edges() {
//		int sum=0;
//		for(int i:map.keySet()) {
//			sum+=map.get(i).size();
//		}
//		return sum/2;
//	}
//	public void removeEdge(int v1,int v2) {
//		map.get(v1).remove(v2);
//		map.get(v2).remove(v1);
//	}
//	public void addvertex(int v) {
//		map.put(v, new HashMap<>());
//	}
//	public void removeVertex(int v) {
//		for(int i:map.get(v).keySet()) {
//			map.get(i).remove(v);
//		}
//		map.remove(v);
//	}
//	public void display() {
//		for(int i:map.keySet()) {
//			System.out.println(i+"-->"+map.get(i));
//		}
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	//	Graph(int v){
//		for(int i=1;i<=v;i++) {
//			map.put(i, new HashMap<>());
//		}
//	}
//	public void addEdge(int v1,int v2,int weight) {
//		map.get(v1).put(v2, weight);
//		map.get(v2).put(v1, weight);
//	}
//	public boolean containsEdge(int v1,int v2) {
//		return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
//	}
//	public boolean containsVertex(int v) {
//		return map.containsKey(v);
//	}
//	public int number_of_edges() {
//		int sum=0;
//		for( int i:map.keySet()) {
//			sum+=map.get(i).size();
//		}
//		return sum/2;
//	}
//	public void removeEdge(int v1,int v2) {
//		map.get(v1).remove(v2);
//		map.get(v2).remove(v1);
//	}
//	public void removeVertex(int v) {
//		for(int i:map.get(v).keySet()) {
//			map.get(i).remove(v);
//		}
//		map.remove(v);
//	}
//	public void display() {
//		for(int i:map.keySet()) {
//			System.out.println(i+"-->"+map.get(i));
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	HashMap<Integer,HashMap<Integer,Integer>> map;
//	Graph(int v){
//		this.map=new HashMap<>();
//		for(int i=1;i<=v;i++) {
//			map.put(i,new HashMap<>());
//		}
//		
//	}
//	public void addEdge(int v1,int v2,int cost) {
//		map.get(v1).put(v2,cost);
//		map.get(v2).put(v1,cost);
//	}
//	public boolean ContainsEdge(int v1,int v2) {
//		return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
//	}
//	public boolean ContainsVertex(int v1) {
//		return map.containsKey(v1);
//	}
//	public int No_of_edges() {
//		int sum=0;
//		for(int i: map.keySet()) {
//			sum+=map.get(i).size();
//		}
//		return sum/2;
//	}
//	public void removeEdge(int v1,int v2) {
//		if(ContainsEdge(v1,v2)) {
//			map.get(v1).remove(v2);
//			map.get(v2).remove(v1);			
//		}
//	}
//	public void removeVertex(int v1) {
//		for(int i:map.get(v1).keySet()) {
//			map.get(i).remove(v1);
//		}
//		map.remove(v1);
//	}
//	public void display() {
//		for(int i:map.keySet()) {
//			System.out.println(i+"-->"+map.get(i));
//		}
//		
//	}
}
class primspair{
	int vtx;
	int aqvtx;
	int cost;
	primspair(int v,int av,int c){
		vtx=v;
		aqvtx=av;
		cost=c;
	}
	@Override
	public String toString() {
		return ""+vtx+" via "+aqvtx+" @ "+cost;
	}
}
class dijkstrapair{
	int vtx;
	String path;
	int cost;
	dijkstrapair(int v,String av,int c){
		vtx=v;
		path=av;
		cost=c;
	}
	@Override
	public String toString() {
		return ""+vtx+" via "+path+" @ "+cost;
	}
}