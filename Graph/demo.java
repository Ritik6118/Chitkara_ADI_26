package Graph;

import java.util.HashSet;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Graph g=new Graph(3);
		Graph g = new Graph(9);
		g.addEdge(1,9,10);
		g.addEdge(1,8,2);
		g.addEdge(1,2,8);
		g.addEdge(1,3,7);
		g.addEdge(3,6,6);
		g.addEdge(4,6,4);
		g.addEdge(4,7,1);
		g.addEdge(5,6,1);
		g.addEdge(5,7,1);
		g.addEdge(6,2,4);
		g.addEdge(6,3,6);
		g.addEdge(6,8,3);
		g.addEdge(6,4,4);
		g.addEdge(7,4,1);
		g.addEdge(7,5,1);
		g.addEdge(7,2,6);
		g.addEdge(8,6,3);
		g.addEdge(8,3,3);
		g.prims();
//		g.dijkstra();
//		System.out.println(g.isCyclic());
//		System.out.println(g.hasPath(1, 4,new HashSet<>()));
//		g.removeEdge(4, 5);
//		g.display();
//		System.out.println(g.hasPath(3,6,new HashSet<>()));
		
//		g.printAll_paths(1 ,2 ,new HashSet<>() , "");
//		System.out.println(g.dfs(4, 5));

//		System.out.println(g.No_of_edges());
		//g.removeEdge(4, 5);
		//g.removevertex(4);
//		g.display();
		
	}

}
