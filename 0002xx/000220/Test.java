import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{1,2,3,1},3,0,true);
        test(new int[]{1,0,1,1},1,2,true);
        test(new int[]{1,5,9,1,5,9},2,3,false);
        
        test(new int[]{-1,-1},1,-1,false); // fuck, who dare put that case
        test(new int[]{0,2147483647},1,2147483647, true); // fuck too
    }
    
    public static void test(int[] nums, int k, int t, boolean expected){
        System.out.println(String.format("nums=%s,k=%d,t=%d,expected=%s",join(nums),k,t,expected));
        Solution solution = new Solution();
        boolean result = solution.containsNearbyAlmostDuplicate(nums,k,t);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(""+v);
            sb.append(",");
        }
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(v.toString());
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
