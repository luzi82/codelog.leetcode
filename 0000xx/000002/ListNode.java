public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode toListNode(int[] intAry){
        if(intAry==null)return null;
        if(intAry.length==0)return null;
        ListNode ret = null;
        for(int i=intAry.length-1;i>=0;--i){
            ListNode old = ret;
            ret = new ListNode(intAry[i]);
            ret.next = old;
        }
        return ret;
    }
    
    public static int[] toIntArray(ListNode head){
        if(head==null)return new int[0];
        int len=0;
        for(ListNode i = head;i!=null;i=i.next)++len;
        
        int[] ret = new int[len];
        int outIdx = 0;
        for(ListNode i = head;i!=null;i=i.next){
            ret[outIdx]=i.val;
            ++outIdx;
        }
        
        return ret;
    }
}
