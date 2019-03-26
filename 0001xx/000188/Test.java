import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(2,new int[]{2,4,1},2);
        test(2,new int[]{3,2,6,5,0,3},7);

        test(1000000000,new int[]{3,2,6,5,0,3},7);
    }
    
    public static void test(int k, int[] prices,int expected){
        System.out.println(String.format("k=%d, prices=%s, expected=%d",k,join(prices),expected));
        Solution solution = new Solution();
        int result = solution.maxProfit(k,prices);
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
