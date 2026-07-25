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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(sameTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.right, subRoot) ||
        isSubtree(root.left, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subTree){
        if(root == null && subTree == null){
            return true;
        }
        if(root != null && subTree != null && root.val == subTree.val){
            return sameTree(root.left,subTree.left) 
            && sameTree(root.right,subTree.right);
        }
        return false;
    }
}
