import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("ABCABC","ABC","ABC");
        test("ABABAB","ABAB","AB");
        test("LEET","CODE","");
    }
    
    public static void test(String str1, String str2,String expected){
        System.out.println(String.format("str1=%s, str2=%s, expected=%s",str1,str2,expected));
        Solution solution = new Solution();
        String result = solution.gcdOfStrings(str1,str2);
        System.out.println(String.format("result=%s",result));
        aassert(result.equals(expected));
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
