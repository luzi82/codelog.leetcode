import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{3,2,2,3},3,new int[]{2,2});
        test(new int[]{0,1,2,2,3,0,4,2},2,new int[]{0,1,3,0,4});
    }
    
    public static void test(int[] nums, int val, int[] expected){
        System.out.println(String.format("nums=%s, val=%d, expected=%s",join(nums),val,join(expected)));
        Solution solution = new Solution();
        int result = solution.removeElement(nums,val);
        System.out.println(String.format("result=%s %d",join(nums),result));
        aassert(result == expected.length);
        for(int i=0;i<result;++i){
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
