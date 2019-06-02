import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// runtime is O(r*r*c)

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] m2 = new int[R+1][C+1];
        
        for(int r=0;r<R;++r){
            for(int c=0;c<C;++c){
                m2[r+1][c+1] = m2[r][c+1] + m2[r+1][c] - m2[r][c] + matrix[r][c];
            }
        }
        
        int ret = 0;
        for(int r1=0;r1<=R;++r1){
            for(int r0=0;r0<r1;++r0){
                int[] a2=new int[C+1];
                for(int c=0;c<=C;++c){
                    a2[c] = m2[r1][c]-m2[r0][c];
                }
                //System.err.println(String.format("a2=%s",Test.join(a2)));
                
                HashMap<Integer,Integer> sumToCountMap = new HashMap<>();
                for(int a2i : a2){
                    int remain = a2i - target;
                    if(sumToCountMap.containsKey(remain)){
                        ret += sumToCountMap.get(remain);
                    }
                    int count = 0;
                    if(sumToCountMap.containsKey(a2i))count = sumToCountMap.get(a2i);
                    sumToCountMap.put(a2i,count+1);
                }
            }
        }
        
        return ret;
    }
}
