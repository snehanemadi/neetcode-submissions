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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root != null){
            q.add(root);
        }

        while(!q.isEmpty()){
            TreeNode rightSide = null;
            for(int i=0, len = q.size() ; i < len ;i++){
                TreeNode node = q.poll();
                
                if(node != null){
                    rightSide = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightSide != null){
                res.add(rightSide.val);
            }
        }
        return res;
    }
}
