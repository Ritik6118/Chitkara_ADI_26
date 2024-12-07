package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Larges_value_in_each_Tree_row {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        if(root==null){
            return li;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            int max=Integer.MIN_VALUE;
            while(n-->0){
                TreeNode tn=q.poll();
                if(tn.val>max){
                    max=tn.val;
                }
                if(tn.left!=null){
                    q.add(tn.left);
                }
                if(tn.right!=null){
                    q.add(tn.right);
                }
            }
            li.add(max);
        }
        return li;
    }
}