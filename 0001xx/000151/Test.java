import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("the sky is blue","blue is sky the");
        test("  hello world!  ","world! hello");
        test("a good   example","example good a");
    }
    
    public static void test(String s,String expected){
        System.out.println(String.format("s=%s, expected=%s",s,expected));
        Solution solution = new Solution();
        String result = solution.reverseWords(s);
        System.out.println(String.format("result=%s",result));
        aassert(result.equals(expected));
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
