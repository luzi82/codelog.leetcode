import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{2,4,3},new int[]{5,6,4},new int[]{7,0,8});
        // my case
        test(new int[]{0},new int[]{0},new int[]{0});
        test(new int[]{0},new int[]{0,1},new int[]{0,1});
        test(new int[]{2,4,5},new int[]{5,6,4},new int[]{7,0,0,1});
    }
    
    public static void test(int[] l1Ary, int[] l2Ary, int[] expectedAry){
        System.out.println(String.format("l1Ary=%s, l2Ary=%s, expected=%s",join(l1Ary),join(l2Ary),join(expectedAry)));
        ListNode l1 = ListNode.toListNode(l1Ary);
        ListNode l2 = ListNode.toListNode(l2Ary);
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1,l2);
        int[] resultAry = ListNode.toIntArray(result);
        System.out.println(String.format("result=%s",join(resultAry)));
        aassert(Arrays.equals(resultAry,expectedAry));
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
