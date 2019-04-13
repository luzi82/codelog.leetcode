import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // sample
        test(10,1,10,1);
        test(6,1,10,0.6);
        test(21,17,10,0.73278);
        
        // my case
        test(100,1,10,1);
        ttest(10000,5000,6000);
        ttest(0,0,10);
        ttest(1,0,10);
        
        // judge case
        ttest(1,0,3);
        test(1,1,2,0.5);
    }
    
    public static void test(int N,int K,int W,double expected){
        System.out.println(String.format("N=%d, K=%d, W=%d, expected=%f",N,K,W,expected));
        Solution solution = new Solution();
        double result = solution.new21Game(N,K,W);
        System.out.println(String.format("result=%f",result));
        aassert(result<expected+0.00001);
        aassert(result>expected-0.00001);
    }
    
    public static void ttest(int N,int K,int W){
        System.out.println(String.format("N=%d, K=%d, W=%d",N,K,W));
        Solution solution = new Solution();
        double result = solution.new21Game(N,K,W);
        System.out.println(String.format("result=%f",result));
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
