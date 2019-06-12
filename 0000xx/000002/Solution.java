import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode ptr = null;
        int carry = 0;
        while(true){
            int v = 0;
            v += carry;
            if(l1!=null){
                v += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                v += l2.val;
                l2 = l2.next;
            }
            carry = v/10;
            v%=10;
            if(ret==null){
                ret=new ListNode(v);
                ptr=ret;
            }else{
                ptr.next = new ListNode(v);
                ptr = ptr.next;
            }
            if(carry>0)continue;
            if(l1!=null)continue;
            if(l2!=null)continue;
            break;
        }
        
        return ret;
    }
}
