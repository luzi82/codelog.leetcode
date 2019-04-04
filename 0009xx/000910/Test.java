import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{1},0,0);
        test(new int[]{0,10},2,6);
        test(new int[]{1,3,6},3,3);
        
        test(new int[]{3,1,10},4,2);
    }
    
    public static void test(int[] A, int K,int expected){
        System.out.println(String.format("A=%s, K=%d, expected=%d",join(A),K,expected));
        Solution solution = new Solution();
        int result = solution.smallestRangeII(A,K);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
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
