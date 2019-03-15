import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean splitArraySameAverage(int[] A) {
        if(A.length<2)return false;
    
        long AAavg = 0;
        for(long i:A){
            AAavg+=i;
        }
        // AAavg = 36
        
        long[] AA = new long[A.length];
        for(int i=0;i<A.length;++i){
            AA[i] = A[i]*A.length - AAavg;
        }
        // AA =   8, 16, 24,32,40,48,56,64
        // AA = -28,-20,-12,-4, 4,12,20,28
        
        HashSet<Long> sumSet = new HashSet<Long>();
        sumSet.add(0L);
        for(int i=0;i<AA.length-1;++i){
            long AAi = AA[i];
            Long[] sumV = sumSet.toArray(new Long[0]);
            for(Long sum:sumV){
                long newSum = sum+AAi;
                if(newSum==0)return true;
                sumSet.add(newSum);
            }
        }
        
        return false;
    }
}
