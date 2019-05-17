import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int ZMAX = 2*N-1;
        
        int[][] ijToVAry = new int[N][N];
        int[][] nextIjToVAry = new int[N][N];
        
        for(int i=0;i<N;++i)for(int j=0;j<N;++j){
            ijToVAry[i][j] = -1;
        }
        ijToVAry[0][0] = 0;
        
        for(int z=0;z<ZMAX;++z){
            for(int i=0;i<N;++i)for(int j=0;j<N;++j){
                nextIjToVAry[i][j] = -1;
            }
            for(int i=0;i<N;++i){
                int ii = z-i;
                if(ii<0)continue;
                if(ii>=N)continue;
                if(grid[i][ii]==-1)continue;
                for(int j=0;j<=i;++j){
                    int jj=z-j;
                    if(jj<0)continue;
                    if(jj>=N)continue;
                    if(grid[j][jj]==-1)continue;
                    int nextVPlus = 0;
                    if(i==j){
                        nextVPlus += grid[i][ii];
                    }else{
                        nextVPlus += grid[i][ii];
                        nextVPlus += grid[j][jj];
                    }
                    int nextV = -1;
                    nextV = Math.max(nextV,getV(i-1,j-1,ijToVAry,nextVPlus));
                    nextV = Math.max(nextV,getV(i-1,j  ,ijToVAry,nextVPlus));
                    nextV = Math.max(nextV,getV(i  ,j-1,ijToVAry,nextVPlus));
                    nextV = Math.max(nextV,getV(i  ,j  ,ijToVAry,nextVPlus));
                    nextIjToVAry[i][j] = nextV;
                }
            }
            int[][] tmpIjToVAry=ijToVAry;ijToVAry=nextIjToVAry;nextIjToVAry=tmpIjToVAry;
        }
        
        return Math.max(0,ijToVAry[N-1][N-1]);
    }
    
    public static int getV(int i,int j,int[][] ijToVAry,int nextVPlus){
        if(i<0)return -1;
        if(j<0)return -1;
        int v = ijToVAry[i][j];
        if(v==-1)return -1;
        return v+nextVPlus;
    }
}
