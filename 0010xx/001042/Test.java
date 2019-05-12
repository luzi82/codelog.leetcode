import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(3,new int[][]{{1,2},{2,3},{3,1}});
        test(4,new int[][]{{1,2},{3,4}});
        test(4,new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3}});
    }
    
    public static void test(int N,int[][] paths){
        System.out.println(String.format("N=%d, paths=%s",N,join(paths)));
        Solution solution = new Solution();
        int[] result = solution.gardenNoAdj(N,paths);
        System.out.println(String.format("result=%s",join(result)));
        aassert(result.length==N);
        for(int i:result){
            assert(i>=1);
            assert(i<=4);
        }
        for(int[] path:paths){
            int a=path[0]-1;
            int b=path[1]-1;
            assert(result[a]!=result[b]);
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
