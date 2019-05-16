import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(2,0,1);
        test(3,1,2);
        // my case
        test(2,1,1);
        test(2,2,0);
        test(3,0,1);
        test(3,1,2);
        test(3,2,2);
        test(3,3,1);
        test(4,0,1);
        test(4,1,3);
        test(4,2,5);
        test(4,3,6);
        test(4,4,5);
        test(4,5,3);
        test(4,6,1);
    }
    
    public static void test(int n,int k,int expected){
        System.out.println(String.format("n=%d, k=%d, expected=%d",n,k,expected));
        Solution solution = new Solution();
        int result = solution.kInversePairs(n,k);
        System.out.println(String.format("result=%d",result));
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
