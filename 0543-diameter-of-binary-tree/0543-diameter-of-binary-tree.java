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
    class pairr{
        int hei;
        int dia;
        pairr(int diam, int heig){
            this.hei=heig;
            this.dia=diam;
        }
    }
    // public int height(TreeNode root){
    //     if (root==null) return 0;
    //     return 1+Math.max(height(root.left), height(root.right));
    // }
    // public int diameter(TreeNode root) {
    //     if(root==null) return 0;
    //     int c1=diameter(root.left);
    //     int c2=diameter(root.right);
    //     int c3= height(root.left) + height(root.right)+1;
    //     return Math.max(c1, Math.max(c2, c3));
    // }
    public int diameterOfBinaryTree(TreeNode root) {
        // return diameter(root)-1; 
        // O(n^2) approach
        return diamter(root).dia-1;
        
    }
    public pairr diamter(TreeNode root){
        if(root==null) return new pairr(0,0);
        pairr one=diamter(root.left);
        pairr two=diamter(root.right);
        pairr ans=new pairr(Math.max(one.hei+two.hei+1, Math.max(one.dia, two.dia)), Math.max(one.hei, two.hei)+1);
        return ans;
    }
}