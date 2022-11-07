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
    // class pair{
    //     int maxSum;
    //     int pathSum;
    //     pair(int maxSum, int pathSum){
    //         this.maxSum=maxSum;
    //         this.pathSum=pathSum;
    //     }
    // }
//     public pair recursive(TreeNode root){
//         if(root==null) return new pair(0, 0);
        
//         //candidate for maximum sum 
//         // in the left subtree
        
//         // left+root+right;
        
//         // in the right subtree;
        
//         pair left=recursive(root.left);
//         pair right=recursive(root.right);
        
//         pair ans= new pair(0,0);
        
//         ans.maxSum=Math.max(left.maxSum, right.maxSum);
//         ans.maxSum=Math.max(ans.maxSum, left.pathSum+root.val+right.pathSum);
        
//         ans.pathSum=Math.max(left.pathSum, right.pathSum)+root.val;
//         return ans;
        
        
//     }
    
    public int maxPathSum(TreeNode root) {
        // pair ans=recursive(root);
        // if(root.left==null && root.right==null) return root.val;
        // return Math.max(ans.maxSum, ans.pathSum);
        max=Integer.MIN_VALUE;
        int val=helper(root);
        return Math.max(val, max);
    }
    
    
    int max=0;
    
    int helper(TreeNode root){
        if(root==null) return 0;
        
        int left=Math.max(helper(root.left), 0);
        int right=Math.max(helper(root.right), 0);
        
        max=Math.max(max, root.val+left+right);
        
        return root.val+Math.max(left, right);
    }
}