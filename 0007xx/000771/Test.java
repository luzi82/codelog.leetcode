import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("aA","aAAbbbb",3);
        test("z","ZZ",0);
    }
    
    public static void test(String J,String S,int expected){
        System.out.println(String.format("J=%s, S=%s, expected=%d",J,S,expected));
        Solution solution = new Solution();
        int result = solution.numJewelsInStones(J,S);
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
