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
    int val; // global to store the sum of each final number

    public void preorder(TreeNode root, StringBuilder bin){
        if(root==null) return ;
        
        bin.append(root.val);
        int size=bin.length();
        if(root.left==null && root.right==null) // found a leaf node
        {
            val+=Integer.parseInt(bin.toString(), 2);
            return;
        }
        preorder(root.left, bin);
        bin.setLength(size);
        preorder(root.right, bin);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        val=0;
        preorder(root, new StringBuilder());
        return val;
    }
}