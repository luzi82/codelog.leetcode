import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[][]{{1,2},{3,4}},new int[][]{{1,2},{2,3}});
        test(new int[][]{{7,7},{7,7}},new int[][]{{1,1},{1,1}});
        test(
          new int[][]{{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}},
          new int[][]{{4,2,3},{1,3,4},{5,1,6},{1,3,4}}
        );
        test(
          new int[][]{{7,3,6},{1,4,5},{9,8,2}},
          new int[][]{{5,1,4},{1,2,3},{6,3,1}}
        );
        // WA
        test(
          new int[][]{{-37,-26,-47,-40,-13},{22,-11,-44,47,-6},{-35,8,-45,34,-31},{-16,23,-6,-43,-20},{47,38,-27,-8,43}},
          new int[][]{{3,4,1,2,7},{9,5,3,10,8},{4,6,2,7,5},{7,9,8,1,6},{12,10,4,5,11}}
        );
    }
    
    public static void test(int[][] matrix,int[][] expected){
        System.out.println(String.format("matrix=%s, expected=%s",join(matrix),join(expected)));
        Solution solution = new Solution();
        int[][] result = solution.matrixRankTransform(matrix);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.deepEquals(result, expected));
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
