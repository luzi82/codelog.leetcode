import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        // for {{1,2},{3,4}}

        int ii = matrix.length; // 2
        int jj = matrix[0].length; // 2

        TreeSet<Integer> vSet = new TreeSet<>();
        HashMap<Integer,HashSet<Integer>> bigToSmallSetMap = new HashMap<>();
        for(int[] vAry:matrix){
          for(int v:vAry){
            vSet.add(v);
          }
        }
        // vSet = 1,2,3,4

        for(int v:vSet){
          bigToSmallSetMap.put(v,new HashSet<>());
        }
        for(int i=0;i<ii;++i){
          int[] vAry = Arrays.copyOf(matrix[i], jj);
          // 1,2  3,4
          Arrays.sort(vAry);
          // 1,2  3,4
          for(int j=0;j<jj-1;++j){
            int small = vAry[j];
            int big = vAry[j+1];
            if(small==big)continue;
            bigToSmallSetMap.get(big).add(small);
            // 2:1, 4:3
          }
        }
        for(int j=0;j<jj;++j){
          int[] vAry = new int[ii];
          for(int i=0;i<ii;++i){
            vAry[i]=matrix[i][j];
          }
          Arrays.sort(vAry);
          // 3,1 4,2
          for(int i=0;i<ii-1;++i){
            int small = vAry[i];
            int big = vAry[i+1];
            if(small==big)continue;
            bigToSmallSetMap.get(big).add(small);
            // 3:1 4:2
          }
        }
        // bigToSmallSetMap:
        // 1: []
        // 2: [1]
        // 3: [1]
        // 4: [3]

        HashMap<Integer,Integer> vToRankMap = new HashMap<>();
        for(int big:vSet){
          int rank = 1;
          for(int small:bigToSmallSetMap.get(big)){
            int rank0 = vToRankMap.get(small);
            rank = Math.max(rank,rank0+1);
          }
          vToRankMap.put(big,rank);
        }
        // 1:1 2:2 3:2 4:3

        int[][] ret = new int[ii][jj];
        for(int i=0;i<ii;++i)for(int j=0;j<jj;++j){
          int v = matrix[i][j];
          v = vToRankMap.get(v);
          ret[i][j] = v;
        }
        // ret: {{1,2},{2,3}}

        return ret;
    }
}
