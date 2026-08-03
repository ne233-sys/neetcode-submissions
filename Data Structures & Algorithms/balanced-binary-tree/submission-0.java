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
    static boolean result = true;
    private int maxDepth(TreeNode root) {
        if(root == null) return 0;

        //postOrder traversal
        int ld = maxDepth(root.left), rd = maxDepth(root.right); 
        if(ld == -1 || rd == -1) return -1;

        if(!(ld + 1 >= rd && rd + 1 >= ld)){
            result = false;
            return -1;
        }

        return 1 + Math.max(ld, rd);
    }

    public boolean isBalanced(TreeNode root) {
        result = true;
        if (root == null) return true;
        maxDepth(root);

        return result;
    }
}
