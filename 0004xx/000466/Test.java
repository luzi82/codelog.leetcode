import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("acb",4,"ab",2,2);
        // my case
        test("a",100,"a",1,100);
        test("a",100,"a",3,33);
        test("aa",100,"a",1,200);
        test("aa",100,"a",3,66);
        test("a",100,"aaa",1,33);
        // test case
        test("lovelive",0,"lovelive",10,0);
    }
    
    public static void test(String s1, int n1, String s2, int n2,int expected){
        System.out.println(String.format("s1=%s, n1=%d, s2=%s, n2=%d, expected=%d",s1,n1,s2,n2,expected));
        Solution solution = new Solution();
        int result = solution.getMaxRepetitions(s1,n1,s2,n2);
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
