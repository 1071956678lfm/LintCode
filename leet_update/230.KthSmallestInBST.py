# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.arr = []

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return None
        self.helper(root, [])
        return self.arr[k - 1]

    def helper(self, root: TreeNode, sequence: list) -> list:
        if not root:
            return None
        if not root.left and not root.right:
            self.arr.append(root.val)
            return [root.val]
        if root.left:
            left_seq = self.helper(root.left, [])
        # print(root.val)
        if root.right:
            right_seq = self.helper(root.right, [])
