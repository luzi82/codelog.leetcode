import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length<=0)return 1;
        if(dungeon[0].length<=0)return 1;
        
        int ix=dungeon.length;
        int jx=dungeon[0].length;
        
        int[][] hp=new int[ix][jx];
        hp[ix-1][jx-1] = Math.max(1,1-dungeon[ix-1][jx-1]);
        
        for(int i=ix-2;i>=0;--i){
            hp[i][jx-1] = Math.max(1,hp[i+1][jx-1]-dungeon[i][jx-1]);
        }
        for(int j=jx-2;j>=0;--j){
            hp[ix-1][j] = Math.max(1,hp[ix-1][j+1]-dungeon[ix-1][j]);
        }
        
        for(int i=ix-2;i>=0;--i)for(int j=jx-2;j>=0;--j){
            int ihp=Math.max(1,hp[i+1][j]-dungeon[i][j]);
            int jhp=Math.max(1,hp[i][j+1]-dungeon[i][j]);
            hp[i][j] = Math.min(ihp,jhp);
        }
        
        return hp[0][0];
    }
}
