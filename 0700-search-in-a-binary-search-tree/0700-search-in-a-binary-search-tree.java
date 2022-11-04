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
//     public TreeNode searchBST(TreeNode root, int val) {
//         if(root==null) return null;
        
//         if(root.val==val) return root;
        
//         if(root.val>val) return searchBST(root.left, val);
//         else return searchBST(root.right, val);
        
//     }
    public TreeNode searchBST(TreeNode root, int val){
        // iterative code with O(n) time, O(1) space
        if(root==null) return null;
        TreeNode temp=root;
        
        while(temp!=null && temp.val!=val){
            if(temp.val>val) temp=temp.left;
            else temp=temp.right;
        }
        if(temp!=null && temp.val==val) return temp;
        return null;
    }
}