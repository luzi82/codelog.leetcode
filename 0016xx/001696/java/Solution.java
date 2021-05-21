import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// slower than Solution.0.java
// but should be better in worst cases

class Solution {
    public int maxResult(int[] nums, int k) {
      int[] idxToSum = new int[nums.length];
      idxToSum[0] = nums[0];
      
      int idxReadDone=-1;
      int idxWrite=1;
      TreeMap<Integer,Integer> vToIdxMap = new TreeMap<>();
      vToIdxMap.put(idxToSum[0],0);
      while(true){
        if(idxWrite>=idxToSum.length)break;
        Map.Entry<Integer,Integer> vToIdxMe = vToIdxMap.lastEntry();
        int v = vToIdxMe.getKey();
        int idx = vToIdxMe.getValue();
        // System.out.println(String.format("CKHEGHLG idx=%d v=%d",idx,v));
        vToIdxMap.remove(v);
        if(idx<=idxReadDone)continue;
        idxReadDone=idx;
        while(true){
          if(idxWrite>idx+k)break;
          if(idxWrite>=idxToSum.length)break;
          idxToSum[idxWrite] = v+nums[idxWrite];
          if(nums[idxWrite]>0){
            vToIdxMap.clear();
          }
          vToIdxMap.put(idxToSum[idxWrite],idxWrite);
          ++idxWrite;
          if(nums[idxWrite-1]>0){
            break;
          }
        }
      }
      return idxToSum[idxToSum.length-1];
    }
}
