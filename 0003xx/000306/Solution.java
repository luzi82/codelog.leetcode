import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.math.*;

class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3)return false;
        char[] cAry = num.toCharArray();
        for(int i=1;i<num.length();++i){
            String a = num.substring(0,i);
            if((!a.equals("0"))&&(a.charAt(0)=='0'))break;
            int aLen = i;
            int remain0 = num.length() - i;
            if(aLen > remain0) break;
            for(int j=i+1;j<num.length();++j){
                String b = num.substring(i,j);
                if((!b.equals("0"))&&(b.charAt(0)=='0'))break;
                int bLen = j-i;
                int remain1 = num.length() - j;
                if(aLen > remain1) break;
                if(bLen > remain1) break;
                BigInteger ai = new BigInteger(a);
                BigInteger bi = new BigInteger(b);
                int k = j;
                while(true){
                    BigInteger ci = ai.add(bi);
                    String c = ci.toString();
                    int k0 = k+c.length();
                    if(k0>cAry.length)break;
                    if(!eq(c,cAry,k))break;
                    if(k0==cAry.length)return true;
                    ai = bi;
                    bi = ci;
                    k = k0;
                }
            }
        }
        return false;
    }
    
    public static boolean eq(String c,char[] cAry,int k){
        for(int i=0;i<c.length();++i){
            if(c.charAt(i)!=cAry[k+i])return false;
        }
        return true;
    }
}
