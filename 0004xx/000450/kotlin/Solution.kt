/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if(root==null){return root}
        if(root.`val`>key){
            root.left = deleteNode(root.left,key)
            return root
        }
        if(root.`val`<key){
            root.right = deleteNode(root.right,key)
            return root
        }
        if(root.left==null){
            return root.right
        }
        if(root.right==null){
            return root.left
        }
        var ptr0 = root.left!!
        var ptr1 = root.left!!.right
        if(ptr1==null){
            ptr0!!.right = root.right
            return ptr0
        }
        while(ptr1!!.right!=null){
            ptr0 = ptr1
            ptr1 = ptr1.right
        }
        ptr0!!
        ptr1!!
        ptr0.right = ptr1.left
        ptr1.left = root.left
        ptr1.right = root.right
        root.left=null
        root.right=null
        return ptr1
    }
}
