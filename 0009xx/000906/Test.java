import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // unit test
        aassert(Solution.toPalindrome(123,5)==12321);
        aassert(Solution.toPalindrome(123,6)==123321);
        aassert(Solution.toPalindrome(0,1)==0);
        aassert(Solution.toPalindrome(1,1)==1);
        aassert(Solution.toPalindrome(9,1)==9);
        aassert(Solution.toPalindrome(1,2)==11);
        aassert(Solution.toPalindrome(9,2)==99);
        aassert(Solution.isPalindrome("a")==true);
        aassert(Solution.isPalindrome("aa")==true);
        aassert(Solution.isPalindrome("aba")==true);
        aassert(Solution.isPalindrome("abba")==true);
        aassert(Solution.isPalindrome("abcba")==true);
        aassert(Solution.isPalindrome("abca")==false);
        aassert(Solution.isPalindrome("aab")==false);
        aassert(Solution.sqrt(0)==0);
        aassert(Solution.sqrt(1)==1);
        aassert(Solution.sqrt(2)==1);
        aassert(Solution.sqrt(3)==1);
        aassert(Solution.sqrt(4)==2);
        aassert(Solution.sqrt(1207701504)==34752);
        // given
        test("4","1000",4);
        // my case
        test("1","1000",5);
        //test("4","1000000000000000000",69);
        // judge
        test("1","19028",8);
    }
    
    public static void test(String L,String R,int expected){
        System.out.println(String.format("L=%s, R=%s, expected=%d",L,R,expected));
        Solution solution = new Solution();
        int result = solution.superpalindromesInRange(L,R);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
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
