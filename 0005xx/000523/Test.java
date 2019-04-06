import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{23, 2, 4, 6, 7},6,true);
        test(new int[]{23, 2, 6, 4, 7},6,true);
        // my case
        test(new int[]{1},6,false);
        test(new int[]{1,1,1,1,1},6,false);
        test(new int[]{0,1,0,1,0,1,0,1,0,1,0},6,false);
        test(new int[]{0,0},6,true); // verified
        
        test(new int[]{23,2,4,6,7},-6,true); // fail case
        test(new int[]{1,1},0,false);
        test(new int[]{1},0,false);
        test(new int[]{0,0},0,true);
        test(new int[]{0},0,false);
        
        test(new int[]{50000000,50000000},100000000,true); // fail case
    }
    
    public static void test(int[] nums, int k,boolean expected){
        System.out.println(String.format("nums=%s, k=%d, expected=%s",join(nums),k,expected));
        Solution solution = new Solution();
        boolean result = solution.checkSubarraySum(nums,k);
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
