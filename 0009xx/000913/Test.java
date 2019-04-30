import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[][]{
            {2,5},
            {3},
            {0,4,5},
            {1,4,5},
            {2,3},
            {0,2,3}
        },0);
        
        // my case
        test(new int[][]{
            {3},
            {2,3},
            {1},
            {0,1}
        },1);
        test(new int[][]{
            {2},
            {2},
            {0,1}
        },2);
        test(new int[][]{
            {2},
            {3},
            {0,4},
            {1,4},
            {2,3}
        },2);
        test(new int[][]{
            {2},
            {3,4},
            {0,3},
            {1,2,4},
            {1,3}
        },2);
    }
    
    public static void test(int[][] graph,int expected){
        System.out.println(String.format("graph=%s, expected=%s",join(graph),expected));
        Solution solution = new Solution();
        int result = solution.catMouseGame(graph);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static String join(int[][][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[][] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
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
