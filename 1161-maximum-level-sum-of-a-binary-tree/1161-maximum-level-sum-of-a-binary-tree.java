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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int level=1;
        int sum=0;
        int minlevel=1;
        int maxSum=root.val;
        while(!queue.isEmpty())
        {
            int qS=queue.size();
            for(int i=0;i<qS;i++){
                TreeNode temp= queue.remove();
                sum+=temp.val;
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            if(sum>maxSum) {
                maxSum=sum;
                minlevel=level;
            }
            sum=0;
            level++;
        }
        return minlevel;
        }
}