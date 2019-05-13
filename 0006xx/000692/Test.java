import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(
            new String[]{"i", "love", "leetcode", "i", "love", "coding"},
            2,
            new String[]{"i", "love"}
        );
        test(
            new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
            4,
            new String[]{"the", "is", "sunny", "day"}
        );
    }
    
    public static void test(String[] words, int k,String[] expected){
        System.out.println(String.format("words=%s, k=%d, expected=%s",join(words),k,join(expected)));
        Solution solution = new Solution();
        List<String> result = solution.topKFrequent(words,k);
        String[] resultAry=result.toArray(new String[0]);
        System.out.println(String.format("result=%s",join(resultAry)));
        aassert(Arrays.equals(resultAry, expected));
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
