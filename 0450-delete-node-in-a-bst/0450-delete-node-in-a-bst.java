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
    public int maxLeft(TreeNode root){
        while(root.right!=null) root=root.right;
        return root.val;
    }
    public TreeNode deletor(TreeNode root, int key){
        
        if(root==null) return null;
        
        if(root.val==key)
        {
            // key found.
            if(root.left==null && root.right==null) return null;
            if(root.left!=null && root.right==null) return root.left;
            if(root.left==null && root.right!=null) return root.right;
            // key has both child
            // find max in left or find min in right logic
            int data=maxLeft(root.left);
            root.val=data;
            root.left=deletor(root.left, data);
            return root;
        }
        else{
            if(root.val>key) root.left=deletor(root.left, key);
            else root.right=deletor(root.right, key);
            return root;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return deletor(root, key);
    }
}