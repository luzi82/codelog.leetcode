import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("eceba",3);
    }
    
    public static void test(String s,int expected){
        System.out.println(String.format("s=%s, expected=%d",s,expected));
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
