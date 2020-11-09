from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def get_TreeNode(v_list: List[int]) -> TreeNode:
    rptr = 0
    node_list = []
    wptr = 0

    root = TreeNode(v_list[rptr])
    rptr += 1
    node_list.append(root)

    while rptr < len(v_list):
        node = node_list[wptr]
        wptr += 1

        v = v_list[rptr]
        rptr += 1
        if v != None:
            tn = TreeNode(v)
            node.left = tn
            node_list.append(tn)
        
        if rptr >= len(v_list): break

        v = v_list[rptr]
        rptr += 1
        if v != None:
            tn = TreeNode(v)
            node.right = tn
            node_list.append(tn)

    return root
