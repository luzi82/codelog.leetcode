import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{3,1,4,2},6,1);
        test(new int[]{6,3,5,2},9,2);
        test(new int[]{1,2,3},3,0);
        test(new int[]{1,2,3},7,-1);
        test(new int[]{1000000000,1000000000,1000000000},3,0);
        // WA 0
        test(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2},148,7);
      }
    
    public static void test(int[] nums, int p,int expected){
        System.out.println(String.format("nums=%s, p=%d expected=%s",join(nums),p,expected));
        Solution solution = new Solution();
        int result = solution.minSubarray(nums,p);
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
