import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int iCnt = grid.length;
        int jCnt = grid[0].length;
        int[] iToMaxAry = new int[iCnt];
        int[] jToMaxAry = new int[jCnt];
        
        for(int i=0;i<iCnt;++i)for(int j=0;j<jCnt;++j){
            iToMaxAry[i] = Math.max(iToMaxAry[i],grid[i][j]);
            jToMaxAry[j] = Math.max(jToMaxAry[j],grid[i][j]);
        }
        
        int ret = 0;
        for(int i=0;i<iCnt;++i)for(int j=0;j<jCnt;++j){
            ret += Math.min(iToMaxAry[i],jToMaxAry[j])-grid[i][j];
        }
        
        return ret;
    }
}
