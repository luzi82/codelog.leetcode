import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(1,2,3,2);
        test(4,2,3,6);
        test(5,2,4,10);
        test(3,6,4,8);
        
        test(10,2,3,15);
    }
    
    public static void test(int N,int A,int B,int expected){
        System.out.println(String.format("N=%d, A=%d, B=%d, expected=%s",N,A,B,expected));
        Solution solution = new Solution();
        int result = solution.nthMagicalNumber(N,A,B);
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
