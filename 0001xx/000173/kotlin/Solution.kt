import java.util.LinkedList
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
class BSTIterator(val root: TreeNode?) {

    val nodeStack = LinkedList<TreeNode?>() // not include ptr
    var ptr:TreeNode? = null
    
    init {
        ptr = root
        while(ptr!!.left!=null){
            nodeStack.addLast(ptr)
            ptr=ptr!!.left
        }
    }
    
    fun next(): Int {
        val ret = ptr!!.`val`
        if(ptr!!.right!=null){
            ptr = ptr!!.right
            while(ptr!!.left!=null){
                nodeStack.addLast(ptr)
                ptr=ptr!!.left
            }
        }else if(nodeStack.size>0){
            ptr = nodeStack.removeLast()!!
        }else{
            ptr = null
        }
        return ret
    }

    fun hasNext(): Boolean {
        return ptr!=null
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
