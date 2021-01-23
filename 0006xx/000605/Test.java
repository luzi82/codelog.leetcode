import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,0,0,0,1},1,true);
        test(new int[]{1,0,0,0,1},2,false);
        // my case
        test(new int[]{1,0,0,0,1},3,false);

        test(new int[]{0,1,0,0,0,1},1,true);
        test(new int[]{0,1,0,0,0,1},2,false);
        test(new int[]{0,1,0,0,0,1},3,false);

        test(new int[]{0,0,1,0,0,0,1},1,true);
        test(new int[]{0,0,1,0,0,0,1},2,true);
        test(new int[]{0,0,1,0,0,0,1},3,false);

        test(new int[]{1,0,0,0,1,0},1,true);
        test(new int[]{1,0,0,0,1,0},2,false);
        test(new int[]{1,0,0,0,1,0},3,false);

        test(new int[]{1,0,0,0,1,0,0},1,true);
        test(new int[]{1,0,0,0,1,0,0},2,true);
        test(new int[]{1,0,0,0,1,0,0},3,false);
    }
    
    public static void test(int[] flowerbed, int n,boolean expected){
        System.out.println(String.format("flowerbed=%s, n=%d, expected=%s",join(flowerbed),n,expected));
        Solution solution = new Solution();
        boolean result = solution.canPlaceFlowers(flowerbed, n);
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
