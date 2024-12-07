package Graph;

import java.util.*;

public class All_paths_from_Source_To_Target {
    HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    HashSet<Integer> visited=new HashSet<>();
    List<List<Integer>> ans=new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for(int i=0;i<graph.length;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j:graph[i]){
                map.get(i).put(j,1);
            }
        }
        findpath(0,graph.length-1,new ArrayList<>());
        // System.out.println(map);
        return ans;
    }
    public void findpath(int src,int des, List<Integer> li){
        if(src==des){
            li.add(src);
            ans.add(new ArrayList<>(li));
            li.remove(li.size()-1);
            return;
        }
        li.add(src);
        for(int i:map.get(src).keySet()){
            if(!visited.contains(i)){
                visited.add(i);
                findpath(i,des,li);
                visited.remove(i);
            }
        }
        li.remove(li.size()-1);
    }

}