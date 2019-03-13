import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// O( n log n), LTE

class Solution {

    long BIG = 100000;

    public int reversePairs(int[] nums) {
        SortedSet<Long> num2Set=new TreeSet<>();
        
        int ans=0;
        
        for(int i=nums.length-1;i>=0;--i){
            long numi=nums[i];
            Set<Long> lesserSet = num2Set.headSet(numi*BIG);
            ans+=lesserSet.size();
            num2Set.add(numi*2*BIG+i);
        }
        
        return ans;
    }

}
