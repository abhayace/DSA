package solutions_lc.BST;

import java.util.HashSet;
import java.util.Set;

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
public class TwoSumBST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetRec(root, set, k);
    }
    boolean findTargetRec(TreeNode root,Set<Integer> set, int k) {
        if(root==null) return false;
        if(set.contains(root.val))
            return true;
        set.add(k-root.val);
        return findTargetRec(root.left,set,k) ||findTargetRec(root.right,set,k);
    }
}
