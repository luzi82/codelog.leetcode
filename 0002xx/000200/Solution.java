import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0)return 0;
        if(grid[0].length==0)return 0;

        int ii=grid.length;
        int jj=grid[0].length;

        int ret=0;
        for(int i=0;i<ii;++i)for(int j=0;j<jj;++j){
            if(grid[i][j]=='0')continue;
            ++ret;
            LinkedList<int[]> q=new LinkedList<>();
            q.addLast(new int[]{i,j});
            while(!q.isEmpty()){
                int[] ij=q.removeFirst();
                int iii=ij[0];int jjj=ij[1];
                if(iii<0)continue;
                if(iii>=ii)continue;
                if(jjj<0)continue;
                if(jjj>=jj)continue;
                if(grid[iii][jjj]=='0')continue;
                grid[iii][jjj]='0';
                q.addLast(new int[]{iii-1,jjj});
                q.addLast(new int[]{iii+1,jjj});
                q.addLast(new int[]{iii,jjj-1});
                q.addLast(new int[]{iii,jjj+1});
            }
        }
        
        return ret;
    }
    
}
