package solutions_lc.bintree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Cousins {
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
    public boolean areCousins(TreeNode root, int x, int y){
        if(root == null) return false;
        Map<Integer, int[]> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;
        while(!queue.isEmpty() && map.size()<2){
            level++;
            int len = queue.size();

            for(int i=0;i<len;i++){
                TreeNode tempNode = queue.poll();
                if(tempNode.left!=null){
                    queue.add(tempNode.left);
                    if(tempNode.left.val == x || tempNode.left.val == y ){
                        map.put(tempNode.left.val, new int[]{level, tempNode.val});
                    }
                }
                if(tempNode.right!=null){
                    queue.add(tempNode.left);
                    if(tempNode.right.val == x || tempNode.right.val == y ){
                        map.put(tempNode.right.val, new int[]{level, tempNode.val});
                    }
                }
            }
        }
        return map.get(x)[0] == map.get(y)[0] && map.get(x)[1] == map.get(y)[1];
    }
}
