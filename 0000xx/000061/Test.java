import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // sample
        test(new int[]{1,2,3,4,5},2,new int[]{4,5,1,2,3});
        test(new int[]{0,1,2},4,new int[]{2,0,1});
        
        // my cases
        test(new int[]{0,1,2},0,new int[]{0,1,2});
        test(new int[]{0,1,2},1,new int[]{2,0,1});
        test(new int[]{0,1,2},2,new int[]{1,2,0});
        test(new int[]{0,1,2},3,new int[]{0,1,2});
    }
    
    public static void test(int[] intAry,int k,int[] expected){
        System.out.println(String.format("intAry=%s, k=%d, expected=%s",join(intAry),k,join(expected)));
        ListNode head = toListNode(intAry);
        Solution solution = new Solution();
        ListNode result = solution.rotateRight(head,k);
        int[] resultIntAry = toIntArray(result);
        System.out.println(String.format("result=%s",join(resultIntAry)));
        aassert(Arrays.equals(expected,resultIntAry));
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
