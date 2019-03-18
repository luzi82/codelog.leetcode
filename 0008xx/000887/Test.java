import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(1,2,2);
        test(2,6,3);
        test(3,14,4);
        test(4,10000,23);
    }
    
    public static void test(int K, int N, int expected){
        System.out.println(String.format("K=%d, N=%d, expected=%d",K,N,expected));
        Solution solution = new Solution();
        int result = solution.superEggDrop(K,N);
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
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
