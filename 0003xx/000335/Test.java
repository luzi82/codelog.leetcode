import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{2,1,1,2},true);
        test(new int[]{1,2,3,4},false);
        test(new int[]{1,1,1,1},true);
        // my cases
        test(new int[]{2,2,4,4,3,1},false);
        test(new int[]{2,2,4,4,3,2},true);
        test(new int[]{2,2,4,4,3,3},true);
        test(new int[]{2,2,4,4,2,1},false);
        test(new int[]{2,2,4,4,2,2},true);
        test(new int[]{2,2,4,4,2,3},true);
        test(new int[]{2,2,4,4,1,1},false);
        test(new int[]{2,2,4,4,1,2},false);
        test(new int[]{2,2,4,4,1,3},false);
        test(new int[]{2,2,4,4,1,4},true);
        test(new int[]{2,2,4,4,1,5},true);
    }
    
    public static void test(int[] x,boolean expected){
        System.out.println(String.format("x=%s, expected=%s",join(x),expected));
        Solution solution = new Solution();
        boolean result = solution.isSelfCrossing(x);
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
