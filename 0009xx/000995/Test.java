import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{3,2,4,1},2,20);
        test(new int[]{3,2,4,1},3,-1);
        test(new int[]{3,5,1,2,6},3,25);
    }
    
    public static void test(int[] stones, int K, int expected){
        System.out.println(String.format("stones=%s, K=%d expected=%d",join(stones),K,expected));
        Solution solution = new Solution();
        int result = solution.mergeStones(stones, K);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(v.toString());
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        for(int v:ary){
            sb.append(Integer.toString(v));
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
