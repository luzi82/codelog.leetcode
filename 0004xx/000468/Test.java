import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("172.16.254.1","IPv4");
        test("2001:0db8:85a3:0:0:8A2E:0370:7334","IPv6");
        test("256.256.256.256","Neither");
        test("0.0.0.0","IPv4");
        test("0.0.0.0.","Neither");
        test("0.0.0.00","Neither");
        test("0.0.0.0:","Neither");
        test("2001:0db8:85a3::0:8A2E:0370:7334","Neither");
        test("2001:0db8:85a3::8A2E:0370:7334","Neither");
        test("2001:0db8:85a3:0:0:8A2E:0370:7334:","Neither");
    }
    
    public static void test(String IP,String expected){
        System.out.println(String.format("IP=%s, expected=%s",IP,expected));
        Solution solution = new Solution();
        String result = solution.validIPAddress(IP);
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
