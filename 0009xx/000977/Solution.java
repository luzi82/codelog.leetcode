import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;++i){
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
