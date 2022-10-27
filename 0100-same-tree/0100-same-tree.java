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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null ) return true;
        if(p==null) return false; // this means p is null q is not
        if(q==null) return false;
        
        if(p.val!=q.val) return false;
        
        // call for p.left and q.left
        if(isSameTree(p.left, q.left)==false) return false;
        if(isSameTree(p.right, q.right)==false) return false;
        
        return true;
    }
}