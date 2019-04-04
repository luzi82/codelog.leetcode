import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int smallestRangeII(int[] A, int K) {
        // alert if A[i] near Integer.MIN_VALUE or Integer.MAX_VALUE
        long[] AA = new long[A.length];
        for(int i=0;i<A.length;++i){
            AA[i] = A[i];
        }
        
        long KK = K;
        KK *= 2;
    
        Arrays.sort(AA);
        long min = AA[0];
        long max = AA[AA.length-1];
        
        long ret = max-min;
        
        for(int i=0;i<AA.length-1;++i){
            AA[i] += KK;
            min = Math.min(AA[0],AA[i]);
            min = Math.min(min,AA[i+1]);
            max = Math.max(max,AA[i]);
            ret = Math.min(ret,max-min);
        }
        
        return (int) ret;
    }
}
