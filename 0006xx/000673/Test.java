import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,3,5,4,7},2);
        test(new int[]{2,2,2,2,2},5);
        // my case
        test(new int[]{1},1);
        test(new int[]{},0);
        test(new int[]{2,2,2,5,1,5},7);
        test(new int[]{1,3,5,4,7,5},3);
        test(new int[]{1,3,5,4,7,5,7},1);
    }
    
    public static void test(int[] nums,int expected){
        System.out.println(String.format("nums=%s, expected=%d",join(nums),expected));
        Solution solution = new Solution();
        int result = solution.findNumberOfLIS(nums);
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
