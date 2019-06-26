import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Long, Integer> valueToIdxMap = new HashMap<>();
        for(int idx=0;idx<nums.length;++idx){
            long v = nums[idx];
            long vv = target - v;
            if(valueToIdxMap.containsKey(vv)){
                int i = valueToIdxMap.get(vv);
                return new int[]{i,idx};
            }
            valueToIdxMap.put(v,idx);
        }
        return null;
    }
}
