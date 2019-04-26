import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(
            new int[][]{
                {1,0,0,0},
                {1,1,1,0}
            },
            new int[][]{
                {1,0}
            },
            new int[]{2}
        );
        test(
            new int[][]{
                {1,0,0,0},
                {1,1,0,0}
            },
            new int[][]{
                {1,1},
                {1,0}
            },
            new int[]{0,0}
        );
        // my case
        test(
            new int[][]{
                {0,0,0,0},
                {1,1,1,0}
            },
            new int[][]{
                {0,0}
            },
            new int[]{0}
        );
        // discussion case
        test(
            new int[][]{
                {1,0,0,0,0,0},
                {1,1,1,1,0,0},
                {1,0,0,1,0,0},
                {1,0,0,1,1,0},
                {0,0,0,0,0,0}
            },
            new int[][]{
                {1,0},
                {2,2},
                {1,3}
            },
            new int[]{8,0,0}
        );
    }
    
    public static void test(int[][] grid, int[][] hits, int[] expected){
        System.out.println(String.format("grid=%s, hits=%s",join(grid),join(hits),expected));
        Solution solution = new Solution();
        int[] result = solution.hitBricks(grid, hits);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.equals(result, expected));
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
