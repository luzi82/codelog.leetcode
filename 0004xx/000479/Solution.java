import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int largestPalindrome(int n) {
        if(n==1)return 9; // hard code
        
        // loop lhs=999,998,997
        long n10=1;
        for(int i=0;i<n;++i){
            n10*=10;
        }
        long lhs=n10-1;
        
        while(true){
            // build v=999999,998899,997799...
            String lhsString = Long.toString(lhs);
            String rhsString = reverse(lhsString);
            long rhs = Long.parseLong(rhsString,10);
            long v = lhs*n10+rhs;
            //System.err.println(v);
            for(long fac=n10-1;fac>=0;--fac){
                if((v%fac==0)&&(v/fac<n10)&&(v/fac>=n10/10)){
                    //System.err.println(String.format("v=%d,fac=%d,v/fac=%d",v,fac,v/fac));
                    return (int)(v%1337);
                }
                if(v/fac>fac)break;
            }
            --lhs;
        }
    }
    
    public static String reverse(String s){
        char[] cAry = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=cAry.length-1;i>=0;--i){
            sb.append(cAry[i]);
        }
        return sb.toString();
    }
}
