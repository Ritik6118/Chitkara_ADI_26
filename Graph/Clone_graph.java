package Graph;
/*
// Definition for a Node.
*/

import java.util.*;
class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class Clone_graph{
    HashMap<Integer,Node> map=new HashMap<>();
    HashSet<Integer> vis=new HashSet<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        bfs(node);
        bfs2(node);
        // System.out.println(map);
        return map.get(node.val);
    }
    public void bfs2(Node n){
        if(vis.contains(n.val)){
            return;
        }
        vis.add(n.val);
        Node cn=map.get(n.val);
        for(Node nd:n.neighbors){
            cn.neighbors.add(map.get(nd.val));
            bfs2(nd);
        }

    }
    public void bfs(Node n){
        if(!map.containsKey(n.val)){
            map.put(n.val,new Node(n.val));
            for(Node nn:n.neighbors){
                bfs(nn);
            }
        }
    }
    
}