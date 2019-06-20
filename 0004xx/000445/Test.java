import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{7,2,4,3},new int[]{5,6,4},new int[]{7,8,0,7});
    }
    
    public static void test(int[] l1, int[] l2,int[] expected){
        System.out.println(String.format("l1=%s, l2=%s, expected=%s",join(l1),join(l2),join(expected)));
        Solution solution = new Solution();
        ListNode ll1 = ListNode.toListNode(l1);
        ListNode ll2 = ListNode.toListNode(l2);
        ListNode result = solution.addTwoNumbers(ll1,ll2);
        int[] resultt = ListNode.toIntArray(result);
        System.out.println(String.format("result=%s",join(resultt)));
        aassert(Arrays.equals(expected,resultt));
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
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
