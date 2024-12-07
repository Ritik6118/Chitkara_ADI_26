package Tree;

//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class Same_Tree{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        else if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean l=isSameTree(p.left,q.left);
        boolean r=isSameTree(p.right,q.right);
        return l&&r;
    }
}