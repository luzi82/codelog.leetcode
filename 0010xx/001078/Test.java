import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
            "alice is a good girl she is a good student","a","good",
            new String[]{"girl","student"}
        );
        test(
            "we will we will rock you","we","will",
            new String[]{"we","rock"}
        );
    }
    
    public static void test(String text, String first, String second, String[] expected){
        System.out.println(String.format("text=%s, first=%s, second=%s, expected=%s",text,first,second,join(expected)));
        Solution solution = new Solution();
        String[] result = solution.findOcurrences(text,first,second);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.equals(result,expected));
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
