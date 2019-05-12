import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer,Set<Integer>> aToBSetMap = new HashMap<Integer,Set<Integer>>();
        for(int i=0;i<N;++i){
            aToBSetMap.put(i,new HashSet<Integer>());
        }
        for(int[] path:paths){
            aToBSetMap.get(path[0]-1).add(path[1]-1);
            aToBSetMap.get(path[1]-1).add(path[0]-1);
        }

        int[] ansAry = new int[N];
        for(int i=0;i<N;++i){
            boolean[] good=new boolean[5];
            for(int j:aToBSetMap.get(i)){
                good[ansAry[j]] = true;
            }
            int k=1;
            for(k=1;k<=4;++k){
                if(!good[k])break;
            }
            ansAry[i] = k;
        }
        
        return ansAry;
    }
}
