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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode curr, temp;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            curr = stack.pop();

            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }

        return root;
    }
}
