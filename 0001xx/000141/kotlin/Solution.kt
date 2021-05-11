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
    fun hasCycle(head: ListNode?): Boolean {
        if(head==null)return false
        var ptr1 = head
        var ptr2 = head
        while(true){
            ptr2=ptr2!!.next
            if(ptr2==null)return false
            if(ptr1==ptr2)return true
            ptr2=ptr2!!.next
            if(ptr2==null)return false
            if(ptr1==ptr2)return true
            ptr1=ptr1!!.next
            if(ptr1==null)return false
            if(ptr1==ptr2)return true
        }
    }
}
