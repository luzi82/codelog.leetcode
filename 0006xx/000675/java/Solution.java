import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    int[][] cellAryAry = null;
    int iCnt;
    int jCnt;

    public int cutOffTree(List<List<Integer>> cellListList) {
      cellAryAry = new int[cellListList.size()][];
      int i,j;
      i=0;
      for(List<Integer> cellList : cellListList){
        cellAryAry[i] = new int[cellList.size()];
        j=0;
        for(Integer cell:cellList){
          cellAryAry[i][j] = cell;
          ++j;
        }
        ++i;
      }
      
      iCnt = cellAryAry.length;
      jCnt = cellAryAry[0].length;
      
      PriorityQueue<Integer> treeSizePq = new PriorityQueue<Integer>();
      for(i=0;i<iCnt;++i)for(j=0;j<jCnt;++j){
        int cell = cellAryAry[i][j];
        if(cell<=1)continue;
        treeSizePq.add(cell);
      }
      
      int ret=0;
      int myI=0;
      int myJ=0;
      while(true){
        if(treeSizePq.size()<=0)break;
        int targetTreeSize = treeSizePq.poll();
        BfsRet bfsRet = bfs(myI,myJ,targetTreeSize);
        //System.out.println(bfsRet.toString());
        if(!bfsRet.found)return -1;
        ret += bfsRet.step;
        myI = bfsRet.i;
        myJ = bfsRet.j;
      }
      
      return ret;
    }
    
    BfsRet bfs(int myI,int myJ,int targetTreeSize){
      if(cellAryAry[myI][myJ]==targetTreeSize){
        return new BfsRet(true,0,myI,myJ);
      }
      int[][] stepAryAry = new int[iCnt][jCnt];
      for(int i=0;i<iCnt;++i)for(int j=0;j<jCnt;++j){
        stepAryAry[i][j]=-1;
      }
      stepAryAry[myI][myJ]=0;
      LinkedList<int[]> ijQueue = new LinkedList<>();
      ijQueue.addLast(new int[]{myI,myJ});
      while(true){
        if(ijQueue.size()<=0)break;
        int[] ij = ijQueue.removeFirst();
        int i=ij[0];int j=ij[1];
        int step = stepAryAry[i][j];
        BfsRet bfsRet;
        bfsRet = _bfs(i,j-1,targetTreeSize,stepAryAry,step+1,ijQueue);
        if(bfsRet!=null)return bfsRet;
        bfsRet = _bfs(i,j+1,targetTreeSize,stepAryAry,step+1,ijQueue);
        if(bfsRet!=null)return bfsRet;
        bfsRet = _bfs(i-1,j,targetTreeSize,stepAryAry,step+1,ijQueue);
        if(bfsRet!=null)return bfsRet;
        bfsRet = _bfs(i+1,j,targetTreeSize,stepAryAry,step+1,ijQueue);
        if(bfsRet!=null)return bfsRet;
      }
      return new BfsRet(false,-1,-1,-1);
    }
    
    BfsRet _bfs(int i,int j,int targetTreeSize,int[][] stepAryAry,int step,LinkedList<int[]> ijQueue){
      if(i<0)return null;
      if(i>=iCnt)return null;
      if(j<0)return null;
      if(j>=jCnt)return null;
      if(cellAryAry[i][j]==0)return null;
      // if(cellAryAry[i][j]>targetTreeSize)return null;
      if(cellAryAry[i][j]==targetTreeSize)return new BfsRet(true,step,i,j);
      if(stepAryAry[i][j]!=-1)return null;
      stepAryAry[i][j] = step;
      ijQueue.addLast(new int[]{i,j});
      return null;
    }
    
    class BfsRet{
      boolean found;
      int step;
      int i;
      int j;
      BfsRet(boolean found,int step,int i,int j){
        this.found=found;
        this.step=step;
        this.i=i;
        this.j=j;
      }
      public String toString(){
        return String.format("found=%s, step=%d, i=%d, j=%d",found,step,i,j);
      }
    }
}
