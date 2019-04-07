import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int reverse(int x) {
        if(x==0)return x;

        // x to char array
        String xStr = Integer.toString(x);
        if(x<0)xStr=xStr.substring(1);
        char[] cAry = xStr.toCharArray();
        
        // reverse
        char[] cAry0 = new char[cAry.length];
        for(int i=0;i<cAry.length;++i){
            cAry0[i] = cAry[cAry.length-1-i];
        }

        // remove heading zero
        int headZeroCount = 0;
        while(true){
            if(headZeroCount>=cAry.length)break;
            if(cAry0[headZeroCount]!='0')break;
            ++headZeroCount;
        }
        char[] cAry1 = new char[cAry.length-headZeroCount];
        for(int i=0;i<cAry1.length;++i){
            cAry1[i] = cAry0[i+headZeroCount];
        }

        // check out bound
        if(cAry1.length==10){
            if(x>0){
                char[] big = Integer.toString(Integer.MAX_VALUE).toCharArray();
                for(int i=0;i<cAry1.length;++i){
                    if(cAry1[i]>big[i])return 0;
                    if(cAry1[i]<big[i])break;
                }
            }else{
                char[] big = Integer.toString(Integer.MIN_VALUE).substring(1).toCharArray();
                for(int i=0;i<cAry1.length;++i){
                    if(cAry1[i]>big[i])return 0;
                    if(cAry1[i]<big[i])break;
                }
            }
        }
        
        // output
        int ret = 0;
        int fac = (x>0)?1:-1;
        for(int i=0;i<cAry1.length;++i){
            ret *= 10;
            ret += fac*(cAry1[i]-'0');
        }
        return ret;
    }
}
