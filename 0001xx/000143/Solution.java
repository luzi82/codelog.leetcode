import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public void reorderList(ListNode head) {
        if(head==null)return;
        
        LinkedList<ListNode> nodeList = new LinkedList<>();
        ListNode ptr = head;
        while(ptr!=null){
            nodeList.addLast(ptr);
            ptr = ptr.next;
        }
        
        ptr = nodeList.pollFirst();
        while(!nodeList.isEmpty()){
            ptr.next = nodeList.pollLast();
            ptr = ptr.next;
            if(nodeList.isEmpty())break;
            ptr.next = nodeList.pollFirst();
            ptr = ptr.next;
        }
        
        ptr.next = null;
    }
}
