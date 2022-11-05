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
    int i=0;
    public int finder(TreeNode root, int k){
        if(root==null) return -1;
        
        // first priority is to keep pushing down towards the left, 
        // and only once you start moving up, you know you have started to the pass
        // the ith smallest numbers
        int left=finder(root.left, k);
        if(left!=-1) return left;
        
        //N
        i++;
        if(i==k) return root.val;
        
        //R
        return finder(root.right, k);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        i=0;
        return finder(root, k);
    }
}