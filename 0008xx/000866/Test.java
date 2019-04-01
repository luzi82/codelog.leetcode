import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(6,7);
        test(8,11);
        test(13,101);

        test(1,2);
        t(1000);
        t(999);
        
        test(6,7);
        test(7,7);
        test(8,11);
        test(9,11);
        test(10,11);
        test(11,11);
        test(12,101);
    }
    
    public static void test(int N,int expected){
        System.out.println(String.format("N=%d, expected=%d",N,expected));
        Solution solution = new Solution();
        int result = solution.primePalindrome(N);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static void t(int N){
        System.out.println(String.format("N=%d",N));
        Solution solution = new Solution();
        int result = solution.primePalindrome(N);
        System.out.println(String.format("result=%d",result));
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
