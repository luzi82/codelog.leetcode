import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        // create dependencyMaskAry
        int[] dependencyMaskAry = new int[n];
        for(int[] dependencyPair:dependencies){
          int src = dependencyPair[0]-1;
          int tar = dependencyPair[1]-1;
          dependencyMaskAry[tar] |= 1<<src;
        }

        // create dependencySrcToTarVecAry
        Vector<Integer>[] dependencyTarToSrcVecAry = new Vector[n];
        for(int i=0;i<n;++i){
          dependencyTarToSrcVecAry[i] = new Vector<>();
        }
        for(int[] dependencyPair:dependencies){
          int src = dependencyPair[0]-1;
          int tar = dependencyPair[1]-1;
          dependencyTarToSrcVecAry[tar].add(src);
        }

        // create nodeDepthAry
        int[] nodeDepthAry = new int[n];
        int[] nodeSrcToTarRemainAry = new int[n];
        for(int[] dependencyPair:dependencies){
          int src = dependencyPair[0]-1;
          ++nodeSrcToTarRemainAry[src];
        }
        LinkedList<Integer> depthQueue = new LinkedList<>();
        for(int i=0;i<n;++i){
          if(nodeSrcToTarRemainAry[i]<=0){
            nodeDepthAry[i] = 1;
            depthQueue.addLast(i);
          }
        }
        while(!depthQueue.isEmpty()){
          int tar = depthQueue.pollFirst();
          int depth = nodeDepthAry[tar]+1;
          for(int src:dependencyTarToSrcVecAry[tar]){
            nodeDepthAry[src] = depth;
            --nodeSrcToTarRemainAry[src];
            if(nodeSrcToTarRemainAry[src]==0){
              depthQueue.addLast(src);
            }
          }
        }

        //System.err.println(String.format("nodeDepthAry=%s",Test.join(nodeDepthAry)));

        TreeSet<Unit> aStarQueue = new TreeSet<Unit>();
        int zeroH = h(0,n,k,nodeDepthAry);
        Unit zeroUnit = new Unit(zeroH,0,0);
        aStarQueue.add(zeroUnit);

        Integer[] stateToGhAry = new Integer[1<<n];
        // for(int i=0;i>stateToGhAry.length;++i){
        //   stateToGhAry[i]=Integer.MAX_VALUE;
        // }
        stateToGhAry[0] = zeroUnit.getGh();

        while(true){
          Unit u = aStarQueue.pollFirst();
          //System.err.println(String.format("process %s",u.toString()));
          if(u.h==0)return u.getGh();

          if(u.getGh()>stateToGhAry[u.state])continue;

          Vector<Integer> availableNodeVec = new Vector<Integer>();
          for(int node=0;node<n;++node){
            // filter node already done
            if((u.state&(1<<node))!=0)continue;

            // filter node dependency solved
            int bad = (~(u.state))&(dependencyMaskAry[node]);
            if(bad!=0)continue;

            availableNodeVec.add(node);
          }

          if(availableNodeVec.size()<=k){
            int nextState = u.state;
            for(int availableNode:availableNodeVec){
              nextState |= (1<<availableNode);
            }
            Unit nextUnit = new Unit(h(nextState,n,k,nodeDepthAry),u.g+1,nextState);
            if((stateToGhAry[nextState]==null)||(nextUnit.getGh()<stateToGhAry[nextState])){
              //System.err.println(String.format("direct add %s",nextUnit.toString()));
              stateToGhAry[nextState] = nextUnit.getGh();
              aStarQueue.add(nextUnit);
            }
          }else{
            ncr(u.state,0,k,availableNodeVec,u.g+1,n,k,nodeDepthAry,aStarQueue,stateToGhAry);
          }
        }
    }

    static void ncr(int state,int start,int remain,Vector<Integer> availableNodeVec,int nextG,int n,int k,int[] nodeDepthAry,TreeSet<Unit> aStarQueue,Integer[] stateToGhAry){
      if(remain==0){
        Unit nextUnit = new Unit(h(state,n,k,nodeDepthAry),nextG,state);
        if((stateToGhAry[state]==null)||(nextUnit.getGh()<stateToGhAry[state])){
          //System.err.println(String.format("ncr add %s",nextUnit.toString()));
          stateToGhAry[state] = nextUnit.getGh();
          aStarQueue.add(nextUnit);
        }
        return;
      }
      ncr(state|(1<<availableNodeVec.get(start)),start+1,remain-1,availableNodeVec,nextG,n,k,nodeDepthAry,aStarQueue,stateToGhAry);
      if(start<availableNodeVec.size()-remain){
        ncr(state,start+1,remain,availableNodeVec,nextG,n,k,nodeDepthAry,aStarQueue,stateToGhAry);
      }
    }

    static int h(int state,int n,int k,int[] nodeDepthAry){
      int oneCount = getOneCount(state);
      int zeroCount = n-oneCount;
      int h = (zeroCount+k-1)/k;

      for(int i=0;i<n;++i){
        if(((state>>i)&1)==1)continue;
        h = Math.max(h,nodeDepthAry[i]);
      }

      return h;
    }

    static int getOneCount(int state){
      int ret=0;
      while(state!=0){
        if((state&1)!=0)++ret;
        state>>=1;
      }
      return ret;
    }

    static class Unit implements Comparable<Unit> {
      final int g;
      final int h;
      final int state;
      public Unit(int h,int g,int state){
        this.g = g;
        this.h = h;
        this.state = state;
      }
      public int getGh(){return this.g+this.h;}
      public int compareTo(Unit other){
        int diff;
        diff = this.getGh() - other.getGh();
        if(diff!=0)return diff;
        diff = this.h - other.h;
        if(diff!=0)return diff;
        diff = this.g - other.g;
        if(diff!=0)return diff;
        diff = this.state - other.state;
        if(diff!=0)return diff;
        return 0;
      }

      public String toString(){
        //System.err.println(String.format("gh=%d, h=%d, g=%d, state=%d",this.getGh(),this.h,this.g,this.state));
        return String.format("gh=%d, h=%d, g=%d, state=%d",this.getGh(),this.h,this.g,this.state);
      }
    }
}
