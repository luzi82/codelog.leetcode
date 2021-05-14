import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int iCnt = rowSum.length;
        int jCnt = colSum.length;

        int[][] retAryAry = new int[iCnt][jCnt];
        int i=0;int j=0;
        
        while(true){
            if(i>=iCnt){break;}
            if(j>=jCnt){break;}
            int v = Math.min(rowSum[i],colSum[j]);
            retAryAry[i][j] = v;
            rowSum[i]-=v;
            colSum[j]-=v;
            if(rowSum[i]==0){++i;}
            if(colSum[j]==0){++j;}
        }
        
        return retAryAry;
    }
}
