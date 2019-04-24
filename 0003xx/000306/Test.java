import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("112358",true);
        test("199100199",true);
        test("1203",false);
        test("1023",false);
        // my case
        test("00000",true);
        test("123",true);
        test("12",false);
        test("1",false);
        test("",false);
    }
    
    public static void test(String num,boolean expected){
        System.out.println(String.format("num=%s, expected=%s",num,expected));
        Solution solution = new Solution();
        boolean result = solution.isAdditiveNumber(num);
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
