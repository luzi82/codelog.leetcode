import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(5,4,new int[]{1,2,4},new int[]{1,3},4);
        test(5,4,new int[]{3,1},new int[]{1},6);
        test(5,4,new int[]{3,3},new int[]{3},9);
    }
    
    public static void test(int h,int w, int[] horizontalCuts,int[] verticalCuts,int expected){
        System.out.println(String.format(
            "h=%d, w=%d, horizontalCuts=%s, verticalCuts=%s, expected=%d",
            h,w,join(horizontalCuts),join(verticalCuts),expected
        ));
        Solution solution = new Solution();
        int result = solution.maxArea(h,w,horizontalCuts,verticalCuts);
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
