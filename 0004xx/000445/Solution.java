import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Len = 1;
        ListNode ptr = l1;
        while(ptr!=null){
            ptr = ptr.next;
            ++l1Len;
        }

        int l2Len = 1;
        ptr = l2;
        while(ptr!=null){
            ptr = ptr.next;
            ++l2Len;
        }
        
        LinkedList<Integer> intList = new LinkedList<>();
        ListNode ptr1=l1;
        ListNode ptr2=l2;
        
        while(true){
            if(l1Len>l2Len){
                intList.addLast(ptr1.val);
                ptr1=ptr1.next;
                --l1Len;
            }else if(l2Len>l1Len){
                intList.addLast(ptr2.val);
                ptr2=ptr2.next;
                --l2Len;
            }else if(ptr1==null){
                break;
            }else{
                intList.addLast(ptr1.val+ptr2.val);
                ptr1=ptr1.next;
                ptr2=ptr2.next;
                --l1Len;
                --l2Len;
            }
        }
        
        LinkedList<Integer> intList2 = new LinkedList<>();
        Iterator<Integer> ptrR = intList.descendingIterator();
        int carry=0;
        while(ptrR.hasNext()){
            int v = ptrR.next();
            v += carry;
            carry = v/10;
            v %= 10;
            intList2.addFirst(v);
        }
        if(carry>0){
            intList2.addFirst(carry);
        }
        
        ListNode ret = null;
        ptrR = intList2.descendingIterator();
        while(ptrR.hasNext()){
            int v = ptrR.next();
            ListNode prev = new ListNode(v);
            prev.next = ret;
            ret = prev;
        }
        
        return ret;
    }
}
