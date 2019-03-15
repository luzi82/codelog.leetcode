import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{1,2,3,4,5,6,7,8},true);
        test(new int[]{1,2},false);
    }
    
    public static void test(int[] A,boolean expected){
        System.out.println(String.format("A=%s, expected=%s",join(A),expected));
        Solution solution = new Solution();
        boolean result = solution.splitArraySameAverage(A);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(""+v);
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
