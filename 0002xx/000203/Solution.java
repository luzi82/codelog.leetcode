import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = null;
        ListNode retPtr = null;
        ListNode ptr = head;
        while(ptr!=null){
            if(ptr.val!=val){
                if(ret==null){
                    ret=ptr;
                }else{
                    retPtr.next=ptr;
                }
                retPtr=ptr;
            }
            ptr = ptr.next;
        }
        if(retPtr!=null){
            retPtr.next = null;
        }
        return ret;
    }
}
