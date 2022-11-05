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
    int sum;
    public boolean ifLeaf(TreeNode root){
        if(root==null) return false;
        if(root.left==null && root.right==null) return true;
        return false;
    }
    
    public void leafLeaves(TreeNode root){
        if(root==null) return;
        
        //for this node check if its leaf node is a left leaf;
        if(ifLeaf(root.left)) sum+=root.left.val;
        leafLeaves(root.left);
        leafLeaves(root.right);
        return;
    } 
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        leafLeaves(root);
        return sum;
    }
}