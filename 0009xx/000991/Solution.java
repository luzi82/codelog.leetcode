import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    // [x][-][-] -> [-][x]
    // [x] n[-]  -> n/2[-] [x] n%2[-]
    public int brokenCalc(int X, int Y) {
        int minusAryLen = 1;
        while(X<Y){
            X*=2;
            ++minusAryLen;
        }
        
        int[] minusAry = new int[minusAryLen];
        minusAry[0] = X-Y;
        
        for(int i=1;i<minusAry.length;++i){
            minusAry[i] = minusAry[i-1]/2;
            minusAry[i-1]%=2;
        }
        
        int ret = minusAryLen-1;
        for(int i=0;i<minusAry.length;++i){
            ret += minusAry[i];
        }
        return ret;
    }
}
