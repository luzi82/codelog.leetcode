import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[][]{
            {-2,-3,3},
            {-5,-10,1},
            {10,30,-5},
        },7);
    }
    
    public static void test(int[][] dungeon,int expected){
        System.out.println(String.format("dungeon=%s, expected=%d",join2(dungeon),expected));
        Solution solution = new Solution();
        int result = solution.calculateMinimumHP(dungeon);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static String join2(int[][] ivv){
        StringBuffer sb=new StringBuffer();
        for(int[] iv:ivv){
            sb.append("{");
            for(int i:iv){
                sb.append(""+i);
                sb.append(",");
            }
            sb.append("},");
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
