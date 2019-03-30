import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new String[]{
            "11110",
            "11010",
            "11000",
            "00000",
        },1);
        test(new String[]{
            "11000",
            "11000",
            "00100",
            "00011",
        },3);
    }
    
    public static void test(String[] grid,int expected){
        System.out.println(String.format("grid=%s, expected=%d",join(grid),expected));
        char[][] ggrid=new char[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;++i){
            ggrid[i] = grid[i].toCharArray();
        }
        Solution solution = new Solution();
        int result = solution.numIslands(ggrid);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
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
