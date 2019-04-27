import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public static final long BIG = 1_000_000_000 + 7;

    public int sumSubseqWidths(int[] A) {
        if(A.length<=1)return 0;
    
        // sort A
        Arrays.sort(A);
        
        // linear algo on A
        long l0=0,l1=0,l2=0;
        for(int aIdx=1;aIdx<A.length;++aIdx){
            l0*=2;l0%=BIG;
            ++l0;l0%=BIG;

            long l00 = l0*(A[aIdx]-A[aIdx-1]);l00%=BIG;
            
            l1*=2;l1%=BIG;
            l1+=l00;l1%=BIG;
            
            l2+=l1;l2%=BIG;
        }
        
        return (int)l2;
    }


}
