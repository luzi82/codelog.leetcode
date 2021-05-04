/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

class Solution {
    fun flatten(root: Node?): Node? {
        return flattenP(root).first
    }
    
    fun flattenP(root:Node?): Pair<Node?,Node?> {
        var ptr:Node? = root
        var end:Node? = ptr
        
        while(ptr!=null){
            if((ptr.child!=null)&&(ptr.next!=null)){
                val next:Node = ptr.next!!
                val childFlatten:Pair<Node?,Node?> = flattenP(ptr.child)
                ptr.child = null
                ptr.next = childFlatten.first
                childFlatten.first!!.prev = ptr
                next.prev = childFlatten.second
                childFlatten.second!!.next = next
                end=childFlatten.second
                ptr = next
                continue
            }
            if(ptr.child!=null){
                val childFlatten:Pair<Node?,Node?> = flattenP(ptr.child)
                ptr.child = null
                ptr.next = childFlatten.first
                childFlatten.first!!.prev = ptr
                end=childFlatten.second
                ptr = null
                continue
            }
            end=ptr
            ptr = ptr.next
        }
        
        return Pair<Node?,Node?>(root,end)
    }
}
