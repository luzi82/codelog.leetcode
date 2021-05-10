import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(10,3,3);
        test(7,-3,-2);
        
        test(0x80000000,-1,0x7fffffff);
        test(0x80000000, 1,0x80000000);
        test(0x80000000, 2,0xc0000000);
        test(0x80000000, 0x80000000,  1);
        test(0x80000000, 0x80000001,  1);
        test(0x80000000, 0x7fffffff, -1);

        test(0x7fffffff,-1,0x80000001);
        test(0x7fffffff, 1,0x7fffffff);
        test(0x7fffffff, 2,0x3fffffff);
        test(0x7fffffff, 0x80000000,  0);
        test(0x7fffffff, 0x80000001, -1);
        test(0x7fffffff, 0x7fffffff,  1);
    }
    
    public static void test(int dividend, int divisor,int expected){
        System.out.println(String.format("dividend=%d, divisor=%d, expected=%d",dividend,divisor,expected));

        long l0=dividend;
        long l1=divisor;
        long lret=l0/l1;
        if(lret<0xffffffff80000000L)lret=0x7fffffff;
        if(lret>0x7fffffff)lret=0x7fffffff;
        System.out.println(String.format("expected=%d, lret=%d",expected,lret));
        aassert(lret == expected);

        Solution solution = new Solution();
        int result = solution.divide(dividend, divisor);
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
