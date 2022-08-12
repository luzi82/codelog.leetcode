# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root,p,q)[0]

    # (ans, pExist, qExist)
    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode'):
        if root == None:
            return (None, False, False)
        ans = None
        pExist = False
        qExist = False
        if root == p:
            pExist = True
        if root == q:
            qExist = True
        lRet = self.dfs(root.left,p,q)
        if(lRet[0]!=None):return lRet
        rRet = self.dfs(root.right,p,q)
        if(rRet[0]!=None):return rRet
        pExist = pExist or lRet[1] or rRet[1]
        qExist = qExist or lRet[2] or rRet[2]
        if pExist and qExist:
            ans = root
        return (ans, pExist, qExist)
            
