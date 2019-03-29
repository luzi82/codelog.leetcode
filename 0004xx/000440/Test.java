import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(23456,1,1);
        test(23456,2,10);
        test(23456,3,100);
    
        checkAll(999);
        checkAll(345);
        checkAll(3456);
        checkAll(12345);
        test(13,2,10);
        for(int i=1;i<=9999;++i){
            checkAll(i);
        }
    }
    
    public static void checkAll(int n){
        LinkedList<String> strList=new LinkedList<>();
        for(int i=1;i<=n;++i){
            strList.addLast(""+i);
        }
        String[] strAry = strList.toArray(new String[0]);
        Arrays.sort(strAry);
        for(int i=1;i<=n;++i){
            Solution solution = new Solution();
            int v = solution.findKthNumber(n,i);
            System.out.println(String.format("n=%d, k=%d, expected=%s, result=%d",n,i,strAry[i-1],v));
            aassert(strAry[i-1].equals(Integer.toString(v)));
        }
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
