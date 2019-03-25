import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("(()",2);
        test(")()())",4);

        test("(())",4);
    }
    
    public static void test(String s,int expected){
        System.out.println(String.format("s=%s, expected=%d",s,expected));
        Solution solution = new Solution();
        int result = solution.longestValidParentheses(s);
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
