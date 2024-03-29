import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int uniquePathsIII(int[][] grid) {
        iCnt = grid.length;
        jCnt = grid[0].length;
        kCnt = iCnt*jCnt;
        
        BitSet startBitSet = new BitSet(kCnt);
        int startI=-1;
        int startJ=-1;
        int zeroCnt = 0;
        for(int i=0;i<iCnt;++i){
            for(int j=0;j<jCnt;++j){
                int k = ijToK(i,j);
                if(grid[i][j]==1){
                    startI=i;startJ=j;
                }
                if(grid[i][j]==0){
                    ++zeroCnt;
                    startBitSet.set(k,true);
                }
                if(grid[i][j]==2){
                    endI=i;endJ=j;
                }
            }
        }
        
        State startState = new State(startBitSet,startI,startJ,zeroCnt);
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
        int kk = ijToK(ii,jj);
        int pathCnt = stateToPathCntMap.get(state);
        if((ii==endI)&&(jj==endJ)){
            if(state.zeroCnt<=0){
                ret += pathCnt;
            }
        }else if(state.bs.get(kk)){
            BitSet newBs = (BitSet)state.bs.clone();
            newBs.set(kk,false);
            State newState = new State(newBs,ii,jj,state.zeroCnt-1);
            if(!stateToPathCntMap.containsKey(newState)){
                stateQueue.addLast(newState);
                stateToPathCntMap.put(newState,pathCnt);
            }else{
                stateToPathCntMap.put(newState,stateToPathCntMap.get(newState)+pathCnt);
            }
        }
    }
    
    int iCnt;int jCnt;int kCnt;
    int endI;int endJ;
    
    class State{
        BitSet bs;
        int i;int j;
        int zeroCnt;
        public State(BitSet bs,int i,int j,int zeroCnt){
            this.bs = bs;
            this.i=i;
            this.j=j;
            this.zeroCnt=zeroCnt;
        }
        public int hashCode(){
            return Objects.hash(bs,i,j,zeroCnt);
        }
        public boolean equals(Object otherr){
            State other = (State)otherr;
            if(!this.bs.equals(other.bs))return false;
            if(this.i!=other.i)return false;
            if(this.j!=other.j)return false;
            if(this.zeroCnt!=other.zeroCnt)return false;
            return true;
        }
    }
    
    int ijToK(int i,int j){
      return i*jCnt+j;
    }
    
}
