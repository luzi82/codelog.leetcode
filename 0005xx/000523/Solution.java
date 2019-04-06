import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)return false;
        if(k==0){
            for(int i=0;i<nums.length-1;++i){
                if((nums[i]==0)&&(nums[i+1]==0))return true;
            }
            return false;
        }
        if(k<0)k=-k;
        HashMap<Integer,Integer> modToCountSumMap = new HashMap<>();
        
        int mod=0;
        modToCountSumMap.put(mod,0);
        
        for(int i=0;i<nums.length;++i){
            mod += nums[i];
            mod %= k;
            if(!modToCountSumMap.containsKey(mod)){
                modToCountSumMap.put(mod,i+1);
            }else if(i+1-modToCountSumMap.get(mod)>=2){
                return true;
            }
        }
        return false;
    }
}
