# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

try:
    TreeNode
except:
    class TreeNode(object):
        def __init__(self, x):
            self.val = x
            self.left = None
            self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        result = []
        self._serialize_dfs(root, result)
        
        return result

    def _serialize_dfs(self, root, result):
        if root == None:
            result.append(None)
        else:
            result.append(root.val)
            self._serialize_dfs(root.left, result)
            self._serialize_dfs(root.right, result)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        ptr_i = [0]
        
        root = self._deserialize_dfs(data, ptr_i)
        
        return root
        
    def _deserialize_dfs(self, data, ptr_i):
        v = data[ptr_i[0]]
        ptr_i[0] += 1
        if v is None:
            return None
        result = TreeNode(v)
        result.left = self._deserialize_dfs(data,ptr_i)
        result.right = self._deserialize_dfs(data,ptr_i)
        return result

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
