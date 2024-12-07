package Graph;

import java.util.*;

public class Rechable_Nodes_with_restrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> visited=new HashSet<>();

        for(int i : restricted){
            set.add(i);
        }
        for(int[] arr : edges){
            if(map.containsKey(arr[0])){
                map.get(arr[0]).add(arr[1]);
            }
            else{
                List<Integer> li=new ArrayList<>();
                li.add(arr[1]);
                map.put(arr[0],li);
            }
            if(map.containsKey(arr[1])){
                map.get(arr[1]).add(arr[0]);
            }
            else{
                List<Integer> li=new ArrayList<>();
                li.add(arr[0]);
                map.put(arr[1],li);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int c=0;
        while(!q.isEmpty()){
            int t=q.size();
            while(t-->0){   
                int a=q.poll();
                // System.out.print(a +" ");
                if(!visited.contains(a) && !set.contains(a)){
                    c++;
                    // System.out.println(a);
                    visited.add(a);
                    for(int i:map.get(a)){
                        q.add(i);
                    }
                }
            }
        }
        return c;
    }
}