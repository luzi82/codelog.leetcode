import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{14,4,18,1,15},3,15,9,3);
        test(new int[]{8,3,16,6,12,20},15,13,11,-1);
        test(new int[]{1,6,2,14,5,17,4},16,9,7,2);

        // TLE
        test(new int[]{1998},1999,2000,2000,3998);
    }
    
    public static void test(int[] forbidden, int a, int b, int x,int expected){
        System.out.println(String.format("forbidden=%s, a=%d, b=%d, x=%d, expected=%d",join(forbidden),a,b,x,expected));
        Solution solution = new Solution();
        int result = solution.minimumJumps(forbidden,a,b,x);
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
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
