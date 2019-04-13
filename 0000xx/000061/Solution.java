import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        ListNode cloneList = clone(head);
        int len = getLength(cloneList);
        k %= len;k = len-k;k %= len;
        if(k==0)return cloneList;
        ListNode[] splited = split(cloneList,k);
        ListNode ret = join(splited[1],splited[0]);
        return ret;
    }
    
    public static ListNode clone(ListNode input){
        if(input==null)return null;
        ListNode ret = new ListNode(input.val);
        ListNode outNode = ret;
        for(ListNode i=input.next;i!=null;i=i.next){
            outNode.next = new ListNode(i.val);
            outNode = outNode.next;
        }
        return ret;
    }
    
    public static int getLength(ListNode input){
        int len = 0;
        for(ListNode i = input;i!=null;i=i.next)++len;
        return len;
    }
    
    public static ListNode[] split(ListNode input,int idx){
        if(idx==0){
            return new ListNode[]{null,input};
        }
        ListNode splitNode = input;
        for(int i=1;i<idx;++i){
            splitNode = splitNode.next;
        }
        
        ListNode rhs = splitNode.next;
        splitNode.next = null;
        
        return new ListNode[]{input,rhs};
    }
    
    public static ListNode join(ListNode lhs,ListNode rhs){
        if(lhs==null)return rhs;
        if(rhs==null)return lhs;
        ListNode i = lhs;
        while(i.next!=null){i=i.next;}
        i.next = rhs;
        return lhs;
    }
}
