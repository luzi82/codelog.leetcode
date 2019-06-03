import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.math.*;

class Test {

    public static void main(String[] argv){
        // no given
        
        // my case
        test("0","0","0");
        test("1","999","1000");
        
        // random case
        Random rand = new Random(1);
        for(int i=0;i<10000;++i){
            BigInteger bi0 = new BigInteger(100,rand);
            BigInteger bi1 = new BigInteger(100,rand);
            BigInteger bi2 = bi0.add(bi1);
            test(bi0.toString(),bi1.toString(),bi2.toString());
        }
    }
    
    public static void test(String num1,String num2,String expected){
        System.out.println(String.format("num1=%s, num2=%s, expected=%s",num1,num2,expected));
        Solution solution = new Solution();
        String result = solution.addStrings(num1,num2);
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
