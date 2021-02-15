import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int ret = nums.length;

        long sumMod = 0L;
        for(int n:nums){
          sumMod += n;
          sumMod %= p;
        }
        if(sumMod==0)return 0;

        long mod=0L;
        HashMap<Integer,Integer> modToIdxMap = new HashMap<>();
        modToIdxMap.put(0,-1);
        for(int idx=0;idx<nums.length;++idx){
          mod += nums[idx];
          mod %= p;
          long targetMod = (mod + p - sumMod) % p;
          if(modToIdxMap.containsKey((int)targetMod)){
            int iidx = modToIdxMap.get((int)targetMod);
            int len = idx - iidx;
            ret = Math.min(len,ret);
          }
          modToIdxMap.put((int)mod,idx);
        }

        if(ret==nums.length)return -1;
        return ret;
    }
}
