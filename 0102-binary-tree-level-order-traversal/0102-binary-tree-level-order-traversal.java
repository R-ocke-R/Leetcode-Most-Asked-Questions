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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root==null) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        List<Integer> shortans= new ArrayList<Integer>();
        
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp==null){
                // change level
                ans.add(shortans);
                shortans=new ArrayList<Integer>();
                if(queue.isEmpty()) break;
                queue.add(null);
            }
            else{
                shortans.add(temp.val);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
        }
        return ans;
    }
}