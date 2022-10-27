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
class Solution {
    public int minHeight(TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        if(root.left==null && root.right==null) return 1;
        return Math.min(minHeight(root.left), minHeight(root.right))+1;
    }
    public int minDepth(TreeNode root) {
        // one of the ways is by switching the maximam height/depth question code
        // but in this question we need to touch the first leaf and return
        // so continuing the question after finding minimum is a waste of TC.
        
        // to touch and return the first leaf we should be using a level order approach. not BFS.(pretty obvious thought)
        // the recursive appraoch will be same as height of a tree using Math.min ()
    //     if(root==null) return 0;
    //     return minHeight(root);
    // }
        
        
        //iterative
        if(root==null) return 0;
        int level=0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {
            TreeNode temp= queue.remove();
            if(temp==null) {
                level++;
                if(queue.isEmpty()) return level;// will return for complete BT.
                queue.add(null);
            }
            else{
                if(temp.left==null && temp.right==null) return level+1; 
            // will return as soon as temp hits a leaf.
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            }
            
        }        
        return level;
    }
}