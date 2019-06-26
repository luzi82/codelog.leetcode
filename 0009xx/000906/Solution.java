import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        
        long lSqrt = sqrt(l);
        lSqrt = Math.max(0,lSqrt-1);
        
        String lSqrtStr = Long.toString(lSqrt);
        int lSqrtDigiCnt = lSqrtStr.length();
        int lSqrtLeftDigiCnt = (lSqrtDigiCnt+1)/2;
        String lSqrtLeftStr = lSqrtStr.substring(0,lSqrtLeftDigiCnt);
        long iSqrtLeft = Long.parseLong(lSqrtLeftStr);
        
        int ret = 0;
        while(true){
            long iSqrt = toPalindrome(iSqrtLeft,lSqrtDigiCnt);
            long i = iSqrt*iSqrt;

            System.err.println(String.format(
                "iSqrtLeft=%d, lSqrtLeftDigiCnt=%d, iSqrt=%d, lSqrtDigiCnt=%d, i=%d",
                iSqrtLeft,lSqrtLeftDigiCnt,iSqrt,lSqrtDigiCnt,i
            ));

            if(i>r)break;
            if(i>=l){
                String iStr = Long.toString(i);
                if(isPalindrome(iStr))++ret;
            }

            ++iSqrtLeft;
            if(Long.toString(iSqrtLeft).length()>lSqrtLeftDigiCnt){
                ++lSqrtDigiCnt;
                lSqrtLeftDigiCnt = (lSqrtDigiCnt+1)/2;
                iSqrtLeft = Long.parseLong("100000000000000000000000000000".substring(0,lSqrtLeftDigiCnt));
            }
        }
        
        return ret;
    }
    
    public static long sqrt(long v){
        if(v==0)return 0;
        long min = 0;
        long max = 1000000010L;
        while(min<max){
            long mid = (min+max)/2;
            long mid2 = mid*mid;
            if(mid2<v){min = mid+1;}
            else if(mid2==v){return mid;}
            else {max=mid;}
        }
        if(min*min>v)--min;
        return min;
    }
    
    public static long toPalindrome(long left,int digiCnt){
        char[] retCharAry = new char[digiCnt];

        String leftStr = Long.toString(left);
        char[] leftCharAry = leftStr.toCharArray();
        
        for(int i=0;i<leftCharAry.length;++i){
            retCharAry[i] = leftCharAry[i];
            retCharAry[retCharAry.length-1-i] = leftCharAry[i];
        }
    
        return Long.parseLong(new String(retCharAry));
    }

    public static boolean isPalindrome(String str){
        char[] charAry = str.toCharArray();
        for(int i=0;i<charAry.length;++i){
            if(charAry[i]!=charAry[charAry.length-1-i])return false;
        }
        return true;
    }
}
