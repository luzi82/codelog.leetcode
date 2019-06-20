import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int countDigitOne(int n) {
        if(n<0)return 0;
        long nn = n;
        long ten = 1;
        
        int ret = 0;
        while(true){
            ret += (nn/(ten*10))*ten;
            ret += Math.max(0,Math.min(nn%(ten*10)-(ten-1),ten));
            if(nn<ten)break;
            ten*=10;
        }
        
        return ret;
    }
}
