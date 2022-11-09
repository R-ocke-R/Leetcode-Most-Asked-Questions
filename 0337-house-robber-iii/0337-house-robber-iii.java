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
    class pair{
        int first;
        int second;
        pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public pair robber(TreeNode root){
        if(root==null) return new pair(0, 0);
        
        pair temp= new pair(0, 0);
        
        pair left=robber(root.left);
        pair right=robber(root.right);
        
        
        temp.second=left.first+right.first;
        temp.first=Math.max(temp.second, root.val+left.second+right.second);
        
        return temp;
    }
    public int rob(TreeNode root) {
        pair ans=robber(root);
        return Math.max(ans.first, ans.second);
    }
}