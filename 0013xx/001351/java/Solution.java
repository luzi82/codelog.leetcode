import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int countNegatives(int[][] grid) {
        int iCnt = grid.length;
        int jCnt = grid[0].length;
        int ret = 0;
        int rIdx = jCnt; // leftest nat idx
        
        for(int i=0;i<iCnt;++i){
            while(true){
                if(rIdx<=0)break;
                //System.out.println(String.format("TUCVSDNH %d %d",rIdx,grid[i][rIdx-1]));
                if(grid[i][rIdx-1]>=0)break;
                --rIdx;
            }
            ret += jCnt-rIdx;
        }
        return ret;
    }
}
