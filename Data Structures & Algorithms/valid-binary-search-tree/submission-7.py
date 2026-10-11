# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def check(node, minimum, maximum):
            # Empty tree is valid
            if node is None:
                return True

            # Current node must be inside the allowed range
            if node.val <= minimum or node.val >= maximum:
                return False

            # Check left and right subtrees
            left_valid = check(node.left, minimum, node.val)
            right_valid = check(node.right, node.val, maximum)

            return left_valid and right_valid

        return check(root, float("-inf"), float("inf"))