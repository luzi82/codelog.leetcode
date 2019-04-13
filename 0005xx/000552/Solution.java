import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public static final int BIG = 1_000_000_007;

    public int checkRecord(int n) {
        long[] countAry = new long[6];
        // 0:A0L0, 1:A0L1, 2:A0L2
        // 3:A1L0, 4:A1L1, 5:A1L2
        countAry[0]=1;
        
        for(int i=0;i<n;++i){
            countAry = calNext(countAry);
        }
        
        long ret = Arrays.stream(countAry).sum();
        ret %= BIG;
        return (int)ret;
    }
    
    public long[] calNext(long[] countAry){
        long[] ret = new long[6];

        ret[0]=countAry[0]+countAry[1]+countAry[2];
        ret[1]=countAry[0];
        ret[2]=countAry[1];
        ret[3]=countAry[0]+countAry[1]+countAry[2]+countAry[3]+countAry[4]+countAry[5];
        ret[4]=countAry[3];
        ret[5]=countAry[4];
        
        for(int i=0;i<6;++i){
            ret[i]%=BIG;
        }
        
        return ret;
    }
}
