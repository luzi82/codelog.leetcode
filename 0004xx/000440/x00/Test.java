import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(999,999,999);
        test(999,990,990);
        test(999,989,99);
        test(999,988,989);
        test(999,979,980);
        test(999,978,98);
        test(999,900,909);
        
        for(int i=1;i<=998;++i){
            Solution solution = new Solution();
            // System.out.println(""+i+" "+solution.findKthNumber(999,i));
            int i0 = solution.findKthNumber(999,i);
            int i1 = solution.findKthNumber(999,i+1);
            aassert(Integer.toString(i0).compareTo(Integer.toString(i1))<0);
            aassert(i0>=1);aassert(i0<=999);
            aassert(i1>=1);aassert(i1<=999);
        }

        for(int i=1;i<=98;++i){
            Solution solution = new Solution();
            // System.out.println(""+i+" "+solution.findKthNumber(99,i));
            int i0 = solution.findKthNumber(99,i);
            int i1 = solution.findKthNumber(99,i+1);
            aassert(Integer.toString(i0).compareTo(Integer.toString(i1))<0);
            aassert(i0>=1);aassert(i0<=99);
            aassert(i1>=1);aassert(i1<=99);
        }
        
        test(111,111,99);

        test(13,2,10);
    }
    
    public static void test(int n,int k,int expected){
        System.out.println(String.format("n=%d, k=%d, expected=%d",n,k,expected));
        Solution solution = new Solution();
        int result = solution.findKthNumber(n,k);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(v.toString());
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
