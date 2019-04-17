import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // unit test
        aassert(Arrays.equals(Solution.getBasedAry(19,3),new int[]{1,0,2,0}));
        aassert(Arrays.equals(Solution.getBasedAry(501,5),new int[]{1,0,0,4,0}));
    
        // given
        test(3,19,5);
        test(5,501,8);
        test(100,100000000,3);
        
        // my case
        test(2,15,5);
        test(2,58,8);
    }
    
    public static void test(int x, int target,int expected){
        System.out.println(String.format("x=%d, target=%d, expected=%s",x,target,expected));
        Solution solution = new Solution();
        int result = solution.leastOpsExpressTarget(x,target);
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
