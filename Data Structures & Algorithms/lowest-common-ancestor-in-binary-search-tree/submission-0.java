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

 //where the split is going to happem thats the LCA
 // where they go to diff sub trees
 // logn - we dont go every single tree, only one node every level so height of the tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            } else {
                return root;
            }
        }
    }
}
