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
    int preIndex;
    // public int finder(int[] inorder, int element){
    //     for(int i=0;i<inorder.length;i++){
    //         if(element==inorder[i]) return i;
    //     }
    //     return -1;
    // }
    public TreeNode builder(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int length, Map<Integer, Integer> mapping){
        
        if(preIndex>=length || inorderStart>inorderEnd) return null;
        
        int element=preorder[preIndex++];
        // int rootInInorder=finder(inorder, element); 
        // in optimized version we just take the value from the map in O(1) getting the solution to O(n)
        int rootInInorder=mapping.get(element);
        
        TreeNode temp= new TreeNode(element);
        temp.left=builder(preorder, inorder, inorderStart, rootInInorder-1, length, mapping);
        temp.right=builder(preorder, inorder, rootInInorder+1, inorderEnd, length, mapping);
        
        return temp;       
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        int n=preorder.length;
        //optimization
        Map<Integer, Integer> mapping= new HashMap<>();
        for(int i=0;i<n;i++){
            mapping.put(inorder[i], i);
        }
        return builder(preorder, inorder, 0, n-1, n, mapping);
    }
}