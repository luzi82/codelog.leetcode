import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        connect(root,Vector<Node>(),0)
        return root
    }
    
    fun connect(root:Node?,stack:Vector<Node>,level:Int){
        if(root==null)return
        if(level<stack.size){
            root.next = stack.get(level)
            stack.set(level,root)
        }else{
            stack.add(root)
        }
        connect(root.right,stack,level+1)
        connect(root.left,stack,level+1)
    }
    
}
