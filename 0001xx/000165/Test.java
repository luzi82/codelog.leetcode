import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("0.1","1.1",-1);
        test("1.0.1","1",1);
        test("7.5.2.4","7.5.3",-1);
        test("1.01","1.001",0);
        test("1.0","1.0.0",0);
    }
    
    public static void test(String version1, String version2, int expected){
        System.out.println(String.format("version1=%s, version2=%s, expected=%d",version1,version2,expected));
        Solution solution = new Solution();
        int result = solution.compareVersion(version1,version2);
        System.out.println(String.format("result=%s",result));
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
