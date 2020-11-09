from typing import List
import collections
import math

try:
    TreeNode
except:
    from treenode import TreeNode

class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        return self.dfs(root.val, root.val, root)
    
    def dfs(self, minn, maxx, root):
        minn_v = abs(root.val - minn)
        maxx_v = abs(root.val - maxx)

        minn = min(root.val, minn)
        maxx = max(root.val, maxx)
        lhs_v = self.dfs(minn, maxx, root.left) if root.left else 0
        rhs_v = self.dfs(minn, maxx, root.right) if root.right else 0
        
        return max(minn_v, maxx_v, lhs_v, rhs_v)
