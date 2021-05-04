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
    fun isPalindrome(head: ListNode?): Boolean {
        var listSize:Int =0
        var ptr:ListNode? = head
        while(ptr!=null){
            listSize+=1
            ptr=ptr.next
        }
        
        //println("listSize=%d".format(listSize))
        
        val listSize2:Int = listSize/2
        val valueList:LinkedList<Int> = LinkedList<Int>()
        ptr = head
        for(i in 0..(listSize2-1)){
            valueList.addLast(ptr!!.`val`)
            //println("add %d".format(ptr!!.`val`))
            ptr=ptr!!.next
        }
        if(listSize%2==1){
            ptr=ptr!!.next
        }
        for(i in 0..(listSize2-1)){
            //println("check %d".format(ptr!!.`val`))
            if(ptr!!.`val`!=valueList.getLast())return false
            valueList.removeLast()
            ptr=ptr!!.next
        }
        return true
    }
}
