import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{4,6,15,35},4);
        test(new int[]{20,50,9,63},2);
        test(new int[]{2,3,6,7,4,12,21,39},8);
        
        test(new int[]{1},1);
        test(new int[]{1,1},1);
        
        test(new int[]{98,39,14,86,56,89,26,59,63},7);
    }
    
    public static void test(int[] A,int expected){
        System.out.println(String.format("A=%s, expected=%d",join(A),expected));
        Solution solution = new Solution();
        int result = solution.largestComponentSize(A);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static void test0(int[] A){
        Solution solution = new Solution();
        int result = solution.largestComponentSize(A);
        System.out.println(String.format("result=%d",result));
    }
    
    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        for(int v:ary){
            sb.append(Integer.toString(v));
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(v.toString());
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
