import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("aabcc","dbbca","aadbbcbcac",true);
        test("aabcc","dbbca","aadbbbaccc",false);
        // my case
        test("aaabbc","aabbd","aaaabbbabcd",false);
        test("aaabbc","aabbd","aaaabbbabdc",false);
        test("aaabbc","aabbd","aaaabbabbcd",true);
        test("aaabbc","aabbd","aaaabbabbdc",true);
        // judge case
        test("aabcc","dbbca","aadbcbbcac",true);

    }
    
    public static void test(String s1, String s2, String s3, boolean expected){
        System.out.println(String.format("s1=%s, s2=%s, s3=%s expected=%s",s1,s2,s3,expected));
        Solution solution = new Solution();
        boolean result = solution.isInterleave(s1,s2,s3);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
