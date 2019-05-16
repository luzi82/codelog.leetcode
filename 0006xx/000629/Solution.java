import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final long BIG = 1_000_000_007L;
    public int kInversePairs(int n, int k) {
        long[] cntAry = new long[k+1];
        long[] nextCntAry = new long[k+1];
        
        cntAry[0] = 1;

        for(int nn=2;nn<=n;++nn){
            long nextCnt = 0;
            for(int kk=0;kk<=k;++kk){
                nextCnt += cntAry[kk];
                if(kk>=nn){
                    nextCnt+=BIG;
                    nextCnt-=cntAry[kk-nn];
                }
                nextCnt%=BIG;
                nextCntAry[kk]=nextCnt;
            }
            long[] tmpAry=cntAry;cntAry=nextCntAry;nextCntAry=tmpAry;
        }

        return (int)cntAry[k];
    }
}
