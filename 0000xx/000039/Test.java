import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{2,3,6,7},7);
        test(new int[]{2,3,5},8);
    }
    
    public static void test(int[] candidates,int target){
        System.out.println(String.format("candidates=%s, target=%d",join(candidates),target));
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(candidates,target);
        for(List<Integer> r:result){
            System.out.println(join(r.toArray(new Integer[0])));
            int sum=0;
            for(int v:r){
                sum+=v;
            }
            aassert(sum==target);
        }
        //boolean result = solution.func(x);
        //System.out.println(String.format("result=%s",result));
        //aassert(result == expected);
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
