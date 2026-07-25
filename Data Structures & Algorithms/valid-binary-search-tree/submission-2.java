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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }

    public boolean isValid(TreeNode root, double left,double right){
        if(root==null){
            return true;
        }
        if(!(root.val > left && root.val < right)){
            return false;
        }
        return isValid(root.left,left,root.val) && isValid(root.right,root.val,right);
    }
}
