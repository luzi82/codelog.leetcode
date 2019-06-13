import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Long,HashMap<Long,Integer>> endToDiffToCountMapMap = new HashMap<>();
        
        int ret = 0;
        for(int i=0;i<A.length;++i){
            long a = A[i];
            if(endToDiffToCountMapMap.containsKey(a)){
                HashMap<Long,Integer> diffToCountMap = endToDiffToCountMapMap.get(a);
                for(Map.Entry<Long,Integer> diffToCount:diffToCountMap.entrySet()){
                    long diff = diffToCount.getKey();
                    int count = diffToCount.getValue();
                    long end = a+diff;
                    ret += count;
                    add(end,diff,count,endToDiffToCountMapMap);
                }
            }
            for(int j=0;j<i;++j){
                long b = A[j];
                long diff = a-b;
                long end = a+diff;
                add(end,diff,1,endToDiffToCountMapMap);
            }
        }
        
        return ret;
    }
    
    public void add(long end,long diff,int count,HashMap<Long,HashMap<Long,Integer>> endToDiffToCountMapMap){
        if(!endToDiffToCountMapMap.containsKey(end)){
            endToDiffToCountMapMap.put(end,new HashMap<Long,Integer>());
        }
        HashMap<Long,Integer> diffToCountMap = endToDiffToCountMapMap.get(end);
        if(!diffToCountMap.containsKey(diff)){
            diffToCountMap.put(diff,0);
        }
        int nextCount = diffToCountMap.get(diff);
        nextCount+=count;
        diffToCountMap.put(diff,nextCount);
    }
}
