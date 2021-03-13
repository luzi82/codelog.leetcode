import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// too complex that I dont want to explain... and still TLE...
class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] nodeToEdgeCountAry = new int[n];
        HashMap<Int2,Integer> nodeNodeToEdgeCountMap = new HashMap<>();
        for(int[] edge:edges){
          int a=edge[0]-1;
          int b=edge[1]-1;
          ++nodeToEdgeCountAry[a];
          ++nodeToEdgeCountAry[b];
          int edgeCount = nodeNodeToEdgeCountMap.getOrDefault(new Int2(a,b), 0);
          ++edgeCount;
          nodeNodeToEdgeCountMap.put(new Int2(a,b),edgeCount);
          nodeNodeToEdgeCountMap.put(new Int2(b,a),edgeCount);
        }

        // for(Map.Entry<Int2,Integer> nodeNodeToEdgeCount:nodeNodeToEdgeCountMap.entrySet()){
        //   System.err.println(String.format("%s: %d",nodeNodeToEdgeCount.getKey(),nodeNodeToEdgeCount.getValue()));
        // }

        TreeMap<Integer,Vector<Integer>> edgeCountToNodeVecMap = new TreeMap<>();
        for(int node=0;node<n;++node){
          int nodeEdgeCount = nodeToEdgeCountAry[node];
          edgeCountToNodeVecMap.computeIfAbsent(nodeEdgeCount, (i)->{return new Vector<Integer>();}).add(node);
        }

        TreeMap<Integer,Integer> edgeCountToNodeCountSumMap = new TreeMap<>(); // inclusive
        int nodeCountSum = 0;
        for(Map.Entry<Integer,Vector<Integer>> edgeCountToNodeVec:edgeCountToNodeVecMap.entrySet()){
          int nodeEdgeCount = edgeCountToNodeVec.getKey();
          int nodeEdgeCountNodeCount = edgeCountToNodeVec.getValue().size();
          nodeCountSum+=nodeEdgeCountNodeCount;
          edgeCountToNodeCountSumMap.put(nodeEdgeCount,nodeCountSum);
        }

        // for(Map.Entry<Integer,Integer> edgeCountToNodeCountSum:edgeCountToNodeCountSumMap.entrySet()){
        //   System.err.println(String.format("edgeCountToNodeCountSum: %d > %d",edgeCountToNodeCountSum.getKey(),edgeCountToNodeCountSum.getValue()));
        // }

        int[] ansAry = new int[queries.length];
        for(int i=0;i<queries.length;++i){
          int q = queries[i]+1; // +1: qt to qte
          int ans = 0;

          // System.err.println(String.format("q=%d",q));

          Map.Entry<Integer,Integer> edgeCountToNodeCountSum = edgeCountToNodeCountSumMap.lowerEntry(q);
          int underNodeCount = edgeCountToNodeCountSum == null ? 0 : edgeCountToNodeCountSum.getValue();
          int overNodeCount = n-underNodeCount;
          // System.err.println(String.format("overNodeCount=%d",overNodeCount));
          // ans += overNodeCount*(n-1);
          ans += (overNodeCount * n) - (overNodeCount*(overNodeCount+1))/2;

          for(Map.Entry<Integer,Vector<Integer>> highEdgeCountToNodeVec:edgeCountToNodeVecMap.headMap(q, false).entrySet()){
            int highEdgeCount = highEdgeCountToNodeVec.getKey();
            int minLowEdgeCount = q-highEdgeCount;
            if(minLowEdgeCount<highEdgeCount){
              NavigableMap<Integer,Vector<Integer>> lowEdgeCountToNodeVecMap = edgeCountToNodeVecMap.tailMap(minLowEdgeCount, true).headMap(highEdgeCount, false);
              // System.err.println(String.format("b=%d > a=[%d,%d]",highEdgeCount,lowEdgeCountToNodeVecMap.firstKey(),lowEdgeCountToNodeVecMap.lastKey()));
              for(Vector<Integer> nodeBList:lowEdgeCountToNodeVecMap.values()){
                for(int nodeB:nodeBList){
                  for(int nodeA:highEdgeCountToNodeVec.getValue()){
                    int edgeCount = nodeToEdgeCountAry[nodeA] + nodeToEdgeCountAry[nodeB] - nodeNodeToEdgeCountMap.getOrDefault(new Int2(nodeA,nodeB), 0);
                    if(edgeCount>=q){
                      // System.err.println(String.format("%d, %d",nodeB,nodeA));
                      ++ans;
                    }
                  }
                }
              }
            }

            if(highEdgeCount+highEdgeCount>=q){
              for(int nodeA:highEdgeCountToNodeVec.getValue()){
                for(int nodeB:highEdgeCountToNodeVec.getValue()){
                  if(nodeA>=nodeB)continue;
                  int edgeCount = nodeToEdgeCountAry[nodeA] + nodeToEdgeCountAry[nodeB] - nodeNodeToEdgeCountMap.getOrDefault(new Int2(nodeA,nodeB), 0);
                  if(edgeCount>=q){
                    // System.err.println(String.format("%d, %d",nodeA,nodeB));
                    ++ans;
                  }
                }
              }
            }
          }

          ansAry[i] = ans;
        }

        return ansAry;
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
