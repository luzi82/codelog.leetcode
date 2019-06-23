import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
            new int[]{0,1,3,4},
            new double[]{1.00000,3.00000,2.37500,2.50000,3.00000}
        );
        test(
            new int[]{0,4,3,2,2},
            new double[]{1.00000,4.00000,2.18182,2.00000,1.00000}
        );
    }
    
    public static void test(int[] countt,double[] expected){
        System.out.println(String.format("countt=%s, expected=%s",join(countt),join(expected)));
        int[] count = Arrays.copyOf(countt,256);
        Solution solution = new Solution();
        double[] result = solution.sampleStats(count);
        System.out.println(String.format("result=%s",join(result)));
        aassert(result!=null);
        aassert(result.length==5);
        for(int i=0;i<5;++i){
            aassert(Math.abs(result[i]-expected[i])<0.0001);
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

    public static String join(double[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(double v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Double.toString(v));
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
