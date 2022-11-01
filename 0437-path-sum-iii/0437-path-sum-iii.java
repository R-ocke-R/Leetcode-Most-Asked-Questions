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
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count=0;
        ArrayList<Integer> path = new ArrayList<>();
        recursive(root, targetSum, path);
        return count;
    }
    public void recursive(TreeNode root, int targetSum, ArrayList<Integer> path){
        if(root==null) return ;
        
        path.add(root.val);
        
        // check if path can make targetSum.
        int size=path.size();
        double sum=0;
        // why from the end-> as the upper ones will make thier paths when they are the last ones in path :-> in thier  function call as root.
        
        for(int i=size-1;i>=0;i--){
            sum+=path.get(i);
            if(sum==targetSum) {
                count++;
            }
        }
        
        recursive(root.left, targetSum, path);
        recursive(root.right, targetSum, path);
        
        path.remove(path.size()-1);                
    }
}