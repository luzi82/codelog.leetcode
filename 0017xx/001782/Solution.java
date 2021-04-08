import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        // create nodeToEdgeCountAry
        int[] nodeToEdgeCountAry = new int[n];
        for(int[] edge:edges){
          int a=edge[0]-1;
          int b=edge[1]-1;
          ++nodeToEdgeCountAry[a];
          ++nodeToEdgeCountAry[b];
        }

        // create nodeNodeToEdgeCountMap
        HashMap<Int2,Integer> nodeNodeToEdgeCountMap = new HashMap<>();
        for(int[] edge:edges){
          int a=edge[0]-1;
          int b=edge[1]-1;
          int aa = Math.min(a,b);
          int bb = Math.max(a,b);
          mapAdd(nodeNodeToEdgeCountMap, new Int2(aa,bb), 1);
        }

        // for(Map.Entry<Int2,Integer> nodeNodeToEdgeCount:nodeNodeToEdgeCountMap.entrySet()){
        //   System.err.println(String.format("%s: %d",nodeNodeToEdgeCount.getKey(),nodeNodeToEdgeCount.getValue()));
        // }

        // create edgeCountToNodeVecMap
        HashMap<Integer,Vector<Integer>> edgeCountToNodeVecMap = new HashMap<>();
        for(int node=0;node<n;++node){
          int nodeEdgeCount = nodeToEdgeCountAry[node];
          edgeCountToNodeVecMap.computeIfAbsent(nodeEdgeCount, (i)->{return new Vector<Integer>();}).add(node);
        }

        HashMap<Integer,Integer> edgeCountToNodeNodeCountMap = new HashMap<>();
        for(int query:queries){
          edgeCountToNodeNodeCountMap.put(query+1,0);
        }
        Vector<Integer> nodeEdgeCountVec = new Vector<>(edgeCountToNodeVecMap.keySet());
        for(int i=0;i<nodeEdgeCountVec.size();++i){
          int nodeEdgeCount0 = nodeEdgeCountVec.get(i);
          int nodeCount0 = edgeCountToNodeVecMap.get(nodeEdgeCount0).size();
          for(int j=0;j<i;++j){
            int nodeEdgeCount1 = nodeEdgeCountVec.get(j);
            int nodeCount1 = edgeCountToNodeVecMap.get(nodeEdgeCount1).size();
            int nodeNodeEdgeCountSum = nodeEdgeCount0 + nodeEdgeCount1;
            int nodeNodeCount = nodeCount0 * nodeCount1;
            // System.err.println(String.format("%d: +%d",nodeNodeEdgeCountSum,nodeNodeCount));
            mapAdd(edgeCountToNodeNodeCountMap, nodeNodeEdgeCountSum, nodeNodeCount);
          }
        }
        for(int i=0;i<nodeEdgeCountVec.size();++i){
          int nodeEdgeCount0 = nodeEdgeCountVec.get(i);
          int nodeCount0 = edgeCountToNodeVecMap.get(nodeEdgeCount0).size();
          int nodeNodeEdgeCountSum = nodeEdgeCount0*2;
          int nodeNodeCount = nodeCount0 * (nodeCount0-1) / 2;
          mapAdd(edgeCountToNodeNodeCountMap, nodeNodeEdgeCountSum, nodeNodeCount);
        }
        // for(Map.Entry<Integer,Integer> edgeCountToNodeNodeCountEntry:edgeCountToNodeNodeCountMap.entrySet()){
        //   System.err.println(String.format("%d: %d",edgeCountToNodeNodeCountEntry.getKey(),edgeCountToNodeNodeCountEntry.getValue()));
        // }
        for(Map.Entry<Int2,Integer> nodeNodeToEdgeCountEntry:nodeNodeToEdgeCountMap.entrySet()){
          Int2 nodeNode = nodeNodeToEdgeCountEntry.getKey();
          int edgeCount = nodeNodeToEdgeCountEntry.getValue();
          int nodeA = nodeNode.a;
          int nodeB = nodeNode.b;
          int oldNodeEdgeCount = nodeToEdgeCountAry[nodeA] + nodeToEdgeCountAry[nodeB];
          int newNodeEdgeCount = oldNodeEdgeCount-edgeCount;
          mapAdd(edgeCountToNodeNodeCountMap,oldNodeEdgeCount,-1);
          mapAdd(edgeCountToNodeNodeCountMap,newNodeEdgeCount,1);
        }
        // for(Map.Entry<Integer,Integer> edgeCountToNodeNodeCountEntry:edgeCountToNodeNodeCountMap.entrySet()){
        //   System.err.println(String.format("%d: %d",edgeCountToNodeNodeCountEntry.getKey(),edgeCountToNodeNodeCountEntry.getValue()));
        // }

        Vector<Integer> nodeNodeEdgeCountVec = new Vector<>(edgeCountToNodeNodeCountMap.keySet());
        nodeNodeEdgeCountVec.sort(null);

        HashMap<Integer,Integer> edgeCountToNodeNodeCountSumMap = new HashMap<>();
        int nodeNodeCountSum = 0;
        for(int i=nodeNodeEdgeCountVec.size()-1;i>=0;--i){
          int nodeNodeEdgeCount = nodeNodeEdgeCountVec.get(i);
          nodeNodeCountSum+=edgeCountToNodeNodeCountMap.get(nodeNodeEdgeCount);
          edgeCountToNodeNodeCountSumMap.put(nodeNodeEdgeCount,nodeNodeCountSum);
        }

        int[] retAry = new int[queries.length];
        for(int i=0;i<queries.length;++i){
          int query = queries[i];
          //System.err.println(String.format("%d",query));
          retAry[i] = edgeCountToNodeNodeCountSumMap.get(query+1);
        }

        return retAry;
    }

    static <T> void mapAdd(Map<T,Integer> map,T key,int v){
      int vv = map.getOrDefault(key,0);
      vv += v;
      map.put(key,vv);
    }

    static class Int2 implements Comparable<Int2>{
      int a;int b;
      public Int2(int a,int b){this.a=a;this.b=b;}
      public int compareTo(Int2 other){
        int diff;
        diff=this.a-other.a;if(diff!=0)return diff;
        diff=this.b-other.b;if(diff!=0)return diff;
        return 0;
      }
      @Override
      public boolean equals(Object other){
        return this.compareTo((Int2)other)==0;
      }
      @Override
      public int hashCode(){
        return Objects.hash(this.a,this.b);
      }
      public String toString(){
        return String.format("a=%d, b=%d",this.a,this.b);
      }
    }

}
