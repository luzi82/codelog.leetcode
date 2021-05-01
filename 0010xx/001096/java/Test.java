import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
            "{a,b}{c{d,e}}",
            new String[]{"acd","ace","bcd","bce"}
        );
        test(
            "{{a,z},a{b,c},{ab,z}}",
            new String[]{"a","ab","ac","z"}
        );
    }
    
    public static void test(String expression,String[] expected){
        System.out.println(String.format("expression=%s, expected=%s",expression,join(expected)));
        Solution solution = new Solution();
        List<String> result = solution.braceExpansionII(expression);
        String[] resultt = result.toArray(new String[0]);
        System.out.println(String.format("result=%s",join(resultt)));
        aassert(Arrays.equals(resultt, expected));
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
