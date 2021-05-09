import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val retVec = Vector<Int>()
        
        val vToIdxListMap = TreeMap<Int,LinkedList<Int>>()
        
        var idx = 0
        var nodePtr = head
        while(nodePtr!=null){
            val v = nodePtr.`val`
            
            val vvList = LinkedList<Int>()
            for(vv in vToIdxListMap.keys){
                if(vv>=v)break
                vvList.addLast(vv)
            }
            
            for(vv in vvList){
                val idxList = vToIdxListMap.get(vv)!!
                for(idx in idxList){
                    retVec.set(idx!!,v)
                }
                vToIdxListMap.remove(vv)
            }
            
            //vToIdxListMap.put(v,idx)
            putVToIdx(vToIdxListMap, v, idx)
            retVec.add(0)
            
            idx++
            nodePtr = nodePtr.next
        }
        
        return retVec.toIntArray()
    }
    
    fun putVToIdx(vToIdxListMap:TreeMap<Int,LinkedList<Int>>, v:Int, idx:Int){
        if(!vToIdxListMap.contains(v)){
            vToIdxListMap.put(v,LinkedList<Int>())
        }
        vToIdxListMap.get(v)!!.addLast(idx)
    }
}
