class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var listLength = 0
        var ptr = head
        while(ptr!=null){
            listLength+=1
            ptr = ptr.next
        }
        
        val middlePos = listLength / 2
        
        ptr = head
        for(i in 0..(middlePos-1)){
            ptr = ptr!!.next
        }
        
        return ptr
    }
}
