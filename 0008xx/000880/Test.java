import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("leet2code3",10,"o");
        test("ha22",5,"h");
        test("a2345678999999999999999",1,"a");

        test("ab22c2", 8,"b");
        test("ab22c2", 9,"c");
        test("ab22c2",10,"a");
    }
    
    public static void test(String S, int K, String expected){
        System.out.println(String.format("S=%s, K=%d, expected=%s", S, K, expected));
        Solution solution = new Solution();
        String result = solution.decodeAtIndex(S,K);
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
