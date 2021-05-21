import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// recursion

class Solution {
    public int numIslands(char[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                ret += dfs(grid,i,j);
            }
        }
        return ret;
    }
    
    public int dfs(char[][] grid,int i,int j){
        if(i<0)return 0;
        if(i>=grid.length)return 0;
        if(j<0)return 0;
        if(j>=grid[i].length)return 0;
        if(grid[i][j]!='1')return 0;
        grid[i][j]='0';
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        return 1;
    }
}
