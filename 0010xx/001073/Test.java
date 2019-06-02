import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,1,1,1,1}, new int[]{1,0,1},new int[]{1,0,0,0,0});
        // judge
        test(new int[]{1,0,1}, new int[]{1,0,1},new int[]{1,1,1,1,0});
    }
    
    public static void test(int[] arr1, int[] arr2,int[] expected){
        System.out.println(String.format("arr1=%s, arr2=%s, expected=%s",join(arr1),join(arr2),join(expected)));
        Solution solution = new Solution();
        int[] result = solution.addNegabinary(arr1,arr2);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.equals(result,expected));
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
