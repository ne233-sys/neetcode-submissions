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
    public static int maxd = 0;

    private int drec(TreeNode root){
        if (root == null) return 0;

        //postOrder traversal
        int ld = drec(root.left), rd = drec(root.right); 
        int temp = 1 + Math.max(ld, rd);
        if(temp > maxd) maxd = temp;
        

        if(root.left != null && root.right != null){ 
            int temp2 = 1 + ld + rd;
            if(temp2 > maxd) maxd = temp2;
        }

        return temp;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxd = 0; //apparently static variables are not reset between test cases in NeetCode
        if (root == null) return 0;
        drec(root);
        return maxd - 1; //my code counts the nodes instead of the edges
    }
}
