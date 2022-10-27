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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // this problem is classic DFS so let me try inorder
        if(root==null) return false;
        
        //root to leaf path so we must check if we reached a leaf
        if(root.left==null && root.right==null){
            if(targetSum==root.val) return true;
            else return false;
        }
        if(hasPathSum(root.left, targetSum-root.val)) return true;
        if(hasPathSum(root.right, targetSum-root.val)) return true; 
        return false;            
    }
}