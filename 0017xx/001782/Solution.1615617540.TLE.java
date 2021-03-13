import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

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

        TreeMap<Integer,Integer> edgeCountToCountMap = new TreeMap<Integer,Integer>();
        for(int b=0;b<n;++b){for(int a=0;a<b;++a){
          int edgeCount = nodeToEdgeCountAry[a]+nodeToEdgeCountAry[b]-nodeNodeToEdgeCountMap.getOrDefault(new Int2(a,b), 0);
          int edgeCountCount = edgeCountToCountMap.getOrDefault(edgeCount, 0);
          ++edgeCountCount;
          edgeCountToCountMap.put(edgeCount,edgeCountCount);
        }}

        TreeMap<Integer,Integer> edgeCountToCountSumMap = new TreeMap<Integer,Integer>();
        int edgeCountCountSum = 0;
        for(Map.Entry<Integer,Integer> edgeCountToCount:edgeCountToCountMap.descendingMap().entrySet()){
          int edgeCount = edgeCountToCount.getKey();
          int edgeCountCount = edgeCountToCount.getValue();
          edgeCountCountSum += edgeCountCount;
          edgeCountToCountSumMap.put(edgeCount, edgeCountCountSum);
        }

        int[] ansAry = new int[queries.length];
        for(int i=0;i<queries.length;++i){
          int q = queries[i];
          int ans = 0;
          if(edgeCountToCountSumMap.containsKey(q)){
            ans = edgeCountToCountSumMap.get(q) - edgeCountToCountMap.get(q);
          }else{
            NavigableMap<Integer,Integer> edgeCountToCountSumMapGt = edgeCountToCountSumMap.tailMap(q, false);
            if(edgeCountToCountSumMapGt.isEmpty()){
              ans = 0;
            }else{
              ans = edgeCountToCountSumMapGt.firstEntry().getValue();
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
