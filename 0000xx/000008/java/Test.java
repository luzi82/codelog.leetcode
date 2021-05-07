import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("42",42);
        test("   -42",-42);
        test("4193 with words",4193);
        test("words and 987",0);
        test("-91283472332",-2147483648);

        test("2147483646",2147483646);
        test("2147483647",2147483647);
        test("2147483648",2147483647);
        test("2147483650",2147483647);

        test("-2147483647",-2147483647);
        test("-2147483648",-2147483648);
        test("-2147483649",-2147483648);
        test("-2147483650",-2147483648);

        test("2147483646 ",2147483646);
        test("2147483647 ",2147483647);
        test("2147483648 ",2147483647);

        test("-2147483647 ",-2147483647);
        test("-2147483648 ",-2147483648);
        test("-2147483649 ",-2147483648);
    }
    
    public static void test(String str,int expected){
        System.out.println(String.format("str=%s, expected=%d",str,expected));
        Solution solution = new Solution();
        int result = solution.myAtoi(str);
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
