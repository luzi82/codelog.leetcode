import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int ret = 0;
        for(int x=-1;x<=grid.length;++x){
            for(int y=0;y<=grid[0].length;++y){
                if(g(grid,x,y)!=g(grid,x+1,y)){
                    ++ret;
                }
            }
        }
        for(int x=0;x<=grid.length;++x){
            for(int y=-1;y<=grid[0].length;++y){
                if(g(grid,x,y)!=g(grid,x,y+1)){
                    ++ret;
                }
            }
        }
        return ret;
    }
    
    public static int g(int[][] grid,int x,int y){
        if(x<0)return 0;
        if(y<0)return 0;
        if(x>=grid.length)return 0;
        if(y>=grid[0].length)return 0;
        return grid[x][y];
    }
}
