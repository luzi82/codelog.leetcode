import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    
    int[][] grid;
    LinkedList<int[]> ijtQueue = new LinkedList<>();
    int freshCnt = 0;
    int iCnt;
    int jCnt;
    int lastT = 0;
    
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        iCnt = grid.length;
        jCnt = grid[0].length;

        for(int i=0;i<iCnt;++i)for(int j=0;j<jCnt;++j){
            int o = grid[i][j];
            if(o==1){
                ++freshCnt;
            }
            if(o==2){
                ijtQueue.addLast(new int[]{i,j,0});
            }
        }
        
        while(true){
            if(freshCnt<=0)break;
            if(ijtQueue.size()<=0)break;
            int[] ijt = ijtQueue.removeFirst();
            int i=ijt[0];
            int j=ijt[1];
            int t=ijt[2];
            spread(i,j-1,t+1);
            spread(i,j+1,t+1);
            spread(i-1,j,t+1);
            spread(i+1,j,t+1);
        }
        
        if(freshCnt>0)return -1;
        
        return lastT;
    }
    
    void spread(int i,int j,int t){
        if(i<0)return;
        if(i>=iCnt)return;
        if(j<0)return;
        if(j>=jCnt)return;
        if(grid[i][j]!=1)return;
        grid[i][j]=2;
        ijtQueue.addLast(new int[]{i,j,t});
        lastT = Math.max(lastT,t);
        --freshCnt;
    }
}
