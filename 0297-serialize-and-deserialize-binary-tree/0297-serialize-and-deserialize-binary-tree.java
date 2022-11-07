/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if(root==null) {
            return "X";
        }
        String left=serialize(root.left);
        String right=serialize(root.right);
        
        return root.val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue=new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String> queue){
        String value=queue.poll();
        if(value.equals("X")) return null;
        
        TreeNode newNode= new TreeNode(Integer.valueOf(value));
        newNode.left=helper(queue);
        newNode.right=helper(queue);
        
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));