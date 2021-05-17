import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int uniquePathsIII(int[][] grid) {
        iCnt = grid.length;
        jCnt = grid[0].length;
        
        int startI=-1;
        int startJ=-1;
        int zeroCnt = 0;
        for(int i=0;i<iCnt;++i){
            for(int j=0;j<jCnt;++j){
                if(grid[i][j]==1){
                    startI=i;startJ=j;
                }
                if(grid[i][j]==0){
                    ++zeroCnt;
                }
            }
        }
        
        State startState = new State(grid,startI,startJ,zeroCnt);
        stateToPathCntMap.put(startState,1);
        stateQueue.addLast(startState);
        
        while(stateQueue.size()>0){
            State state = stateQueue.removeFirst();
            checkMove(state,state.i,state.j-1);
            checkMove(state,state.i,state.j+1);
            checkMove(state,state.i-1,state.j);
            checkMove(state,state.i+1,state.j);
        }
        
        return ret;
    }
    
    int ret = 0;
    
    HashMap<State,Integer> stateToPathCntMap=new HashMap<State,Integer>();
    LinkedList<State> stateQueue = new LinkedList<State>();
    
    void checkMove(State state,int ii,int jj){
        if(ii<0)return;
        if(ii>=iCnt)return;
        if(jj<0)return;
        if(jj>=jCnt)return;
        int pathCnt = stateToPathCntMap.get(state);
        if(state.grid[ii][jj]==2){
            if(state.zeroCnt<=0){
                ret += pathCnt;
            }
        }else if(state.grid[ii][jj]==0){
            int[][] newGrid = clone(state.grid);
            newGrid[state.i][state.j]=-1;
            newGrid[ii][jj]=1;
            State newState = new State(newGrid,ii,jj,state.zeroCnt-1);
            if(!stateToPathCntMap.containsKey(newState)){
                stateQueue.addLast(newState);
                stateToPathCntMap.put(newState,pathCnt);
            }else{
                stateToPathCntMap.put(newState,stateToPathCntMap.get(newState)+pathCnt);
            }
        }
    }
    
    int iCnt;int jCnt;
    
    class State{
        int[][] grid;
        int i;int j;int zeroCnt;
        public State(int[][]grid,int i,int j,int zeroCnt){
            this.grid = grid;
            this.i=i;
            this.j=j;
            this.zeroCnt=zeroCnt;
        }
        public int hashCode(){
            return Objects.hash(grid,i,j,zeroCnt);
        }
        public boolean equals(Object otherr){
            State other = (State)otherr;
            if(!Arrays.deepEquals(this.grid,other.grid)){
                return false;
            }
            if(this.i!=other.i)return false;
            if(this.j!=other.j)return false;
            if(this.zeroCnt!=other.zeroCnt)return false;
            return true;
        }
    }
    
    int[][] clone(int[][] oriAryAry){
        int[][] retAry = new int[iCnt][jCnt];
        for(int i=0;i<iCnt;++i)for(int j=0;j<jCnt;++j){
            retAry[i][j] = oriAryAry[i][j];
        }
        return retAry;
    }
    
}
