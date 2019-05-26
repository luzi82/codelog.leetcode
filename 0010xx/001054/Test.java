import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,1,1,2,2,2});
        test(new int[]{1,1,1,1,2,2,3,3});
    }
    
    public static void test(int[] barcodes){
        System.out.println(String.format("barcodes=%s",join(barcodes)));
        int[] barcodesSorted = barcodes.clone();
        Arrays.sort(barcodesSorted);
        Solution solution = new Solution();
        int[] result = solution.rearrangeBarcodes(barcodes);
        System.out.println(String.format("result=%s",join(result)));
        int[] resultSorted = result.clone();
        Arrays.sort(resultSorted);
        aassert(Arrays.equals(barcodesSorted, resultSorted));
        for(int i=0;i<result.length-1;++i){
            aassert(result[i]!=result[i+1]);
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
