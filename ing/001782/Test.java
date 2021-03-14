import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
          4,
          new int[][]{{1,2},{2,4},{1,3},{2,3},{2,1}},
          new int[]{2,3},
          new int[]{6,5}
        );
        test(
          5,
          new int[][]{{1,5},{1,5},{3,4},{2,5},{1,3},{5,1},{2,3},{2,5}},
          new int[]{1,2,3,4,5},
          new int[]{10,10,9,8,6}
        );
    }
    
    public static void test(int n, int[][] edges, int[] queries,int[] expected){
        System.out.println(String.format("n=%d, edges=%s, queries=%s, expected=%s",n,join(edges),join(queries),join(expected)));
        Solution solution = new Solution();
        int[] result = solution.countPairs(n,edges,queries);
        System.out.println(String.format("result=%s",join(result)));
        // aassert(result == expected);
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

    public static String join(boolean[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(boolean v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Boolean.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(long[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(long v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Long.toString(v));
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

    public static int[][] to2D(int[] vAry, int l){
      int[][] ret = new int[vAry.length/l][l];
      for(int i=0;i<vAry.length;++i){
        ret[i/l][i%l]=vAry[i];
      }
      return ret;
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
