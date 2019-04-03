import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    static class Unit{
        String s;
        long lhsLen;
        long rhsLen;
    }

    public String decodeAtIndex(String S, int K) {
        long k = K-1;
        Unit[] unitAry = new Unit[100];
        
        long lenDone = 0;
        int unitDone = 0;
        StringBuffer sb=new StringBuffer();
        
        char[] cAry = S.toCharArray();
        for(char c:cAry){
            if((c>='0')&&(c<='9')){
                Unit u = new Unit();
                u.s = sb.toString();
                u.lhsLen = lenDone;
                lenDone += u.s.length();
                u.rhsLen = lenDone;
                unitAry[unitDone++] = u;

                sb = new StringBuffer();
                int ci = c-'0';
                lenDone *= ci;
            }else{
                sb.append(c);
            }
        }
        {
            Unit u = new Unit();
            u.s = sb.toString();
            u.lhsLen = lenDone;
            lenDone += u.s.length();
            u.rhsLen = lenDone;
            unitAry[unitDone++] = u;
        }

        for(int i=unitDone-1;i>=0;--i){
            Unit u = unitAry[i];
            k%=u.rhsLen;
            if(k<u.lhsLen)continue;
            k-=u.lhsLen;
            int kk = (int)k;
            return u.s.substring(kk,kk+1);
        }
        
        throw new Error();
    }
}
