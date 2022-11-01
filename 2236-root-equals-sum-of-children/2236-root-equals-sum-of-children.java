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
//     public int recursive(TreeNode root){
//         if(root==null) return true;
        
//         int left=recursive(root.left);
//         int right=recursive(root.right);
        
//         if(left+right)
//     }
    public boolean checkTree(TreeNode root) {
        if(root.left.val+root.right.val==root.val) return true;
        return false;
    }
}