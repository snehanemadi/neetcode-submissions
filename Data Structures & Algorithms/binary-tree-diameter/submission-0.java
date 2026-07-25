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

 // root not nesessarily have to be the part of the solution
 // height if a null tree is -1
 // height if the tree is 1 + Max(left,right)
 // D = H of L + H of R + 2

class Solution {
    private int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dia;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        dia = Math.max(dia, 2 + left + right);

        return 1 + Math.max(left, right);
    }
}
