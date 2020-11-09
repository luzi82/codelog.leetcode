import code
import treenode

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.maxAncestorDiff(treenode.get_TreeNode(input))
    print(result)
    assert(result == expected)

# given
test([8,3,10,1,6,None,14,None,None,4,7,13],7)
test([1,None,2,None,0,3],3)
