import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,0,1,0,1},new int[]{0,3});
        test(new int[]{1,1,0,1,1},new int[]{-1,-1});
        // my case
        test(new int[]{1,0,1,0,1,0},new int[]{1,4});
        test(new int[]{1,0,1,0,1,0,0},new int[]{-1,-1});
        test(new int[]{1,0,1,0,0,1,0},new int[]{1,4});
        test(new int[]{1,0,0,1,0,1,0},new int[]{1,5});
        // judge
        test(new int[]{0,0,0},new int[]{0,2});
    }
    
    public static void test(int[] A,int[] expected){
        System.out.println(String.format("A=%s, expected=%s",join(A),join(expected)));
        Solution solution = new Solution();
        int[] result = solution.threeEqualParts(A);
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
