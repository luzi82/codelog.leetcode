import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int rIdx = 0;
        int wIdx = 0;
        while(rIdx<nums.length){
            int v = nums[rIdx];
            if(v!=val){
                nums[wIdx] = v;
                ++wIdx;
            }
            ++rIdx;
        }
        
        return wIdx;
    }
}
