import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,1,2},new int[]{1,2});
        test(new int[]{0,0,1,1,1,2,2,3,3,4},new int[]{0,1,2,3,4});
        // my case
        test(new int[]{},new int[]{});
        test(new int[]{1},new int[]{1});
        test(new int[]{1,1},new int[]{1});
        test(new int[]{1,2},new int[]{1,2});
    }
    
    public static void test(int[] nums,int[] expected){
        System.out.println(String.format("nums=%s, expected=%s",join(nums),join(expected)));
        Solution solution = new Solution();
        int result = solution.removeDuplicates(nums);
        System.out.println(String.format("result=%d,%s",result,join(nums)));
        aassert(result == expected.length);
        for(int i=0;i<expected.length;++i){
            aassert(nums[i] == expected[i]);
        }
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
