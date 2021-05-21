import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// this solution is fast in result
// but should be worst in large scale worst case

class Solution {
    public int maxResult(int[] nums, int k) {
        int[] idxToSum = new int[nums.length];
        for(int idx=0;idx<idxToSum.length;++idx){
          idxToSum[idx]=Integer.MIN_VALUE;
        }
        idxToSum[0] = nums[0];
        int idx=0;
        while(true){
          if(idx>=idxToSum.length-1)break;
          int oldSum = idxToSum[idx];
          int bestIdx = -1;
          int bestV = Integer.MIN_VALUE;
          for(int j=1;j<=k;++j){
            int idx0 = idx+j;
            if(idx0>=nums.length)break;
            int v = nums[idx0];
            int newSum = oldSum+v;
            idxToSum[idx0] = Math.max(idxToSum[idx0],newSum);
            if(idxToSum[idx0]>=bestV){
              bestV=idxToSum[idx0];
              bestIdx=idx0;
            }
            if(v>=0){
              bestIdx=idx0;
              break;
            }
          }
          idx=bestIdx;
        }
        return idxToSum[idxToSum.length-1];
    }
}
