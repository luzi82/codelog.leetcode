import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int cherryPickup(int[][] grid) {
        int iCnt = grid.length;
        int jCnt = grid[0].length;
        
        int[][] abToCherryCnt = new int[jCnt][jCnt];
        for(int a=0;a<jCnt;++a)for(int b=0;b<jCnt;++b){
            abToCherryCnt[a][b] = -1;
        }
        abToCherryCnt[0][jCnt-1]=grid[0][0]+grid[0][jCnt-1];
        
        int[][] nextAbToCherryCnt = new int[jCnt][jCnt];
        for(int i=1;i<iCnt;++i){
            for(int a=0;a<jCnt;++a)for(int b=0;b<jCnt;++b){
                nextAbToCherryCnt[a][b] = -1;
            }
            for(int a=0;a<jCnt;++a){
                for(int b=0;b<jCnt;++b){
                    int oldCherry = abToCherryCnt[a][b];
                    if(oldCherry<0)continue;
                    for(int a1=a-1;a1<=a+1;++a1){
                        if(a1<0)continue;
                        if(a1>=jCnt)continue;
                        for(int b1=b-1;b1<=b+1;++b1){
                            if(b1<0)continue;
                            if(b1>=jCnt)continue;
                            int newCherry = 0;
                            if(a1==b1){
                                newCherry = grid[i][a1];
                            }else{
                                newCherry = grid[i][a1]+grid[i][b1];
                            }
                            newCherry += oldCherry;
                            nextAbToCherryCnt[a1][b1] = Math.max(nextAbToCherryCnt[a1][b1],newCherry);
                        }
                    }
                }
            }
            int[][] tmpAbToCherryCnt = abToCherryCnt;
            abToCherryCnt = nextAbToCherryCnt;
            nextAbToCherryCnt = tmpAbToCherryCnt;
        }
        int ret = 0;
        for(int a=0;a<jCnt;++a)for(int b=0;b<jCnt;++b){
            ret = Math.max(ret,abToCherryCnt[a][b]);
        }
        return ret;
    }
}
