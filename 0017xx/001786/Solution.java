import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    static final long BIG = 1_000_000_000L + 7L;

    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer,Integer>[] nodeToNodeToWeightMapAry = new HashMap[n];
        for(int i=0;i<n;++i){
          nodeToNodeToWeightMapAry[i] = new HashMap<>();
        }

        for(int[] edge:edges){
          int a = edge[0]-1;
          int b = edge[1]-1;
          int w = edge[2];
          nodeToNodeToWeightMapAry[a].put(b, w);
          nodeToNodeToWeightMapAry[b].put(a, w);
        }

        // cal nodeToDepthAry from node n-1 
        int[] nodeToDepthAry = new int[n];
        for(int i=0;i<n;++i){nodeToDepthAry[i]=Integer.MAX_VALUE;}
        TreeSet<Int2> bfsQueue = new TreeSet<Int2>();
        nodeToDepthAry[n-1]=0;
        bfsQueue.add(new Int2(0,n-1));
        while(!bfsQueue.isEmpty()){
          Int2 depthNode = bfsQueue.pollFirst();
          int depth = depthNode.a;
          int src = depthNode.b;
          if(nodeToDepthAry[src]!=depth)continue;
          for(Map.Entry<Integer,Integer> tarWeight:nodeToNodeToWeightMapAry[src].entrySet()){
            int tar = tarWeight.getKey();
            int weight = tarWeight.getValue();
            int tarDepth = depth+weight;
            if(tarDepth<nodeToDepthAry[tar]){
              nodeToDepthAry[tar]=tarDepth;
              bfsQueue.add(new Int2(tarDepth,tar));
            }
          }
        }
        // System.err.println(String.format("nodeToDepthAry=%s",Test.join(nodeToDepthAry)));

        Int2[] ndepthNodeAry = new Int2[n];
        for(int i=0;i<n;++i){
          ndepthNodeAry[i] = new Int2(-nodeToDepthAry[i],i);
        }
        Arrays.sort(ndepthNodeAry);

        long[] nodeToPathCountAry = new long[n];
        nodeToPathCountAry[0] = 1;

        for(Int2 ndepthNode:ndepthNodeAry){
          // System.err.println(ndepthNode.toString());
          int tar = ndepthNode.b;
          int tarDepth = nodeToDepthAry[tar];
          for(int src:nodeToNodeToWeightMapAry[tar].keySet()){
            int srcDepth = nodeToDepthAry[src];
            if(srcDepth<=tarDepth)continue;
            nodeToPathCountAry[tar]+=nodeToPathCountAry[src];
            nodeToPathCountAry[tar]%=BIG;
          }
        }

        return (int)nodeToPathCountAry[n-1];
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
      public String toString(){
        return String.format("a=%d, b=%d",this.a,this.b);
      }
    }
}
