import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0)return 0;
        HashSet<Integer> pairSet = new HashSet<>();
        HashSet<Integer> numSet = new HashSet<>();
        for(int num:nums){
            if(numSet.contains(num+k)){
                pairSet.add(num);
            }
            if(numSet.contains(num-k)){
                pairSet.add(num-k);
            }
            numSet.add(num);
        }

        return pairSet.size();
    }
}
