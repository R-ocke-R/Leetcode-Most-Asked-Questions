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
    public int balanced(TreeNode root){
        // optimally I need height and need to check for balanced
        if(root==null) return 0;
        int left=balanced(root.left);
        int right=balanced(root.right);
        if(left==-1 || right ==-1) return -1;
        if(Math.abs(left-right)<=1) {
            return Math.max(left, right)+1;
        }
        else{ 
            return -1;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if(balanced(root)==-1) return false;
        return true;
    }
}