import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        aassert(String.join(" ",new String[]{"a","b"}).equals("a b"));
        test(123,"One Hundred Twenty Three");
    }
    
    public static void test(int x,String expected){
        System.out.println(String.format("x=%d, expected=%s",x,expected));
        Solution solution = new Solution();
        String result = solution.numberToWords(x);
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
