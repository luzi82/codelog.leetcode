import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(2,987);
        // my case
        test(1,9);
        // all case
        for(int i=1;i<=8;++i){
            ttest(i);
        }
    }
    
    public static void test(int n,int expected){
        System.out.println(String.format("n=%d, expected=%d",n,expected));
        Solution solution = new Solution();
        int result = solution.largestPalindrome(n);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static void ttest(int n){
        System.out.println(String.format("n=%d",n));
        Solution solution = new Solution();
        int result = solution.largestPalindrome(n);
        System.out.println(String.format("result=%d",result));
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
