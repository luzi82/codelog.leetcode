import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,2,6,3,4,5,6},6,new int[]{1,2,3,4,5});
    }
    
    public static void test(int[] headAry, int val,int[] expectedAry){
        System.out.println(String.format("headAry=%s, val=%d, expectedAry=%s",join(headAry),val,join(expectedAry)));
        ListNode head = toListNode(headAry);
        Solution solution = new Solution();
        ListNode result = solution.removeElements(head,val);
        int[] resultAry = toIntArray(result);
        System.out.println(String.format("resultAry=%s",join(resultAry)));
        aassert(Arrays.equals(resultAry,expectedAry));
    }

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
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
