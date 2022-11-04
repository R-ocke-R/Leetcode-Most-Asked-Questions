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
    public void inorder(TreeNode root, ArrayList<Integer> path){
        //O(n)+stack space and O(n) time complexity approach
        if(root==null) return;
        if(root.left!=null) inorder(root.left, path);
        path.add(root.val);
        if(root.right!=null) inorder(root.right, path);
        
    }
    public boolean check(TreeNode root, int minRange, int maxRange){
        
        if(root==null) return true;
        
        if(minRange>root.val || root.val>maxRange) return false;
        
        if(root.left!=null) if(root.left.val>=root.val || !check(root.left, minRange, root.val-1)) return false;
        
        if(root.right!=null) if(root.right.val<= root.val || !check(root.right, root.val+1, maxRange)) return false;
        
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        // ArrayList<Integer> path=new ArrayList<>();
        // inorder(root, path);
        // int size=path.size();
        // for(int i=0;i<size-1;i++){
        //     if(path.get(i)>=path.get(i+1)) return false;
        // }
        // return true;
        
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}