import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// somehow complex idea, make use of bin search

class Solution {
    public int countNegatives(int[][] grid) {
      int iCnt = grid.length;
      int jCnt = grid[0].length;
      int[] iToNegLeftIdxAry = new int[iCnt];
      iToNegLeftIdxAry[0] = getNegLeftIdx(grid[0],-1,jCnt);
      iToNegLeftIdxAry[iCnt-1] = getNegLeftIdx(grid[iCnt-1],-1,iToNegLeftIdxAry[0]);
      dfs(iToNegLeftIdxAry,0,iCnt-1,grid);
      int ret=0;
      for(int negLeftIdx:iToNegLeftIdxAry){
        // System.err.println(String.format("MMJAYKCD %d",negLeftIdx));
        ret+=jCnt-negLeftIdx;
      }
      return ret;
    }
    
    void dfs(int[]iToNegLeftIdxAry,int start,int end,int[][] grid){
      if(start>=end-1)return;
      int mid = (start+end)/2;
      iToNegLeftIdxAry[mid] = getNegLeftIdx(grid[mid],iToNegLeftIdxAry[end]-1,iToNegLeftIdxAry[start]);
      dfs(iToNegLeftIdxAry,start,mid,grid);
      dfs(iToNegLeftIdxAry,mid,end,grid);
    }
    
    // vAry[startIdx] must be +ve, or -1
    // vAry[endIdx] must be -ve, or len
    // ret: left most idx of neg value, or len
    public int getNegLeftIdx(int[] vAry,int startIdx,int endIdx){
      while(startIdx<endIdx-1){
        int midIdx = (startIdx+endIdx)/2;
        int midV = vAry[midIdx];
        if(midV<0){
          endIdx = midIdx;
        }else{
          startIdx = midIdx;
        }
      }
      return endIdx;
    }
}
