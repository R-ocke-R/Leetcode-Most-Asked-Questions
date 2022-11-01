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
//     class pair{
//         TreeNode tnode;
//         int level;
//         pair(TreeNode temp, int line){
//             tnode=temp;
//             level=line;
//         }
//     }
//     public List<Integer> rightSideView(TreeNode root) {
        
//         List<Integer> ans=new ArrayList<>(); // to store answer
//         if(root==null) return ans;
        
//         Queue<pair> queue= new LinkedList<>(); // for level order traversal
//         queue.add(new pair(root, 0));
        
//         Map<Integer, Integer> map=new TreeMap<>(); // to store the mapping with the line. and treemap to get sorted order
//         while(!queue.isEmpty()){
//             pair temp=queue.remove();
            
//             map.put(temp.level, temp.tnode.val);
            
//             // else we don't add, as a value exist for this line.
//             if(temp.tnode.left!=null) queue.add(new pair(temp.tnode.left, temp.level+1));
//             if(temp.tnode.right!=null) queue.add(new pair(temp.tnode.right, temp.level+1));
            
//         }
//         for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//             ans.add(entry.getValue());
//         }
//         return ans;
//     }
    public List<Integer> rightSideView(TreeNode root){
        // / this  function is better than above, as we don't need pair, nor we need a map.
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);
        // boolean print=true; for left view simpler then right view.
        int last=root.val;
        while(!queue.isEmpty())
        {
            TreeNode temp= queue.remove();
            if(temp==null) {
                ans.add(last);
                if(queue.isEmpty()) return ans;
                queue.add(null);
                continue;
            }
            // if(print){ ans.add(temp.val); print=false; } for left view
            last=temp.val;
            
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
        return ans;
    }
}