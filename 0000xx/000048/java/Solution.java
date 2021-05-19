import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int iCnt = size/2;
        int jCnt = (size+1)/2;
        
        for(int i=0;i<iCnt;++i)for(int j=0;j<jCnt;++j){
            int nw = matrix[i][j];
            int ne = matrix[j][size-1-i];
            int se = matrix[size-1-i][size-1-j];
            int sw = matrix[size-1-j][i];
            matrix[i][j] = sw;
            matrix[j][size-1-i] = nw;
            matrix[size-1-i][size-1-j] = ne;
            matrix[size-1-j][i] = se;
        }
    }
}
