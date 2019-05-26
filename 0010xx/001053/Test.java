import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{3,2,1},new int[]{3,1,2});
        test(new int[]{1,1,5},new int[]{1,1,5});
        test(new int[]{1,9,4,6,7},new int[]{1,7,4,6,9});
        test(new int[]{3,1,1,3},new int[]{1,3,1,3});
    }
    
    public static void test(int[] A,int[] expected){
        System.out.println(String.format("A=%s, expected=%s",join(A),join(expected)));
        Solution solution = new Solution();
        int[] result = solution.prevPermOpt1(A);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.equals(result, expected));
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
