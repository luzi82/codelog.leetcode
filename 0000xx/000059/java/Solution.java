import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] retAryAry = new int[n][n];
        
        int di = 0;
        int dj = 1;
        
        int i=0;
        int j=0;
        for(int k=1;k<=n*n;++k){
            retAryAry[i][j] = k;
            int ii = i+di;
            int jj = j+dj;
            boolean good = true;
            good = good && (ii>=0) && (ii<n);
            good = good && (jj>=0) && (jj<n);
            good = good && (retAryAry[ii][jj]==0);
            if(!good){
                int t = di;
                di = dj;
                dj = -t;
                ii = i+di;
                jj = j+dj;
            }
            i = ii;
            j = jj;
        }
        
        return retAryAry;
    }
}
