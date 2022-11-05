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
    public void inorder(ArrayList<Integer> path, TreeNode root){
        if(root==null) return ;
        inorder(path, root.left);
        path.add(root.val);
        inorder(path, root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        inorder(path, root);
        
        int i=0;
        int j=path.size()-1;
        
        while(i<j) {
            int value=path.get(i)+path.get(j);
            
            if(value==k) return true;
            
            if(value<k) i++;
            else j--;
        }
        return false;
    }
}